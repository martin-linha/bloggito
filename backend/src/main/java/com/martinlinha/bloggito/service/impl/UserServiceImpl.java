package com.martinlinha.bloggito.service.impl;

import com.martinlinha.bloggito.persistance.dao.UserDao;
import com.martinlinha.bloggito.persistance.entity.UserDetail;
import com.martinlinha.bloggito.service.UserService;
import com.martinlinha.bloggito.service.domain.GithubRepo;
import com.martinlinha.bloggito.service.domain.GithubRepoDetail;
import com.martinlinha.bloggito.service.domain.StackOverflowDetail;
import com.martinlinha.bloggito.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Arrays;

/**
 * Created by martinlinha on 20.02.17.
 */
@Transactional
@Service
public class UserServiceImpl extends AbstractCrudServiceImpl<UserDetail, Long> implements UserService {

    @Autowired
    private UserDao userDao;
    @Value("${bloggito.github.username}")
    private String githubUsername;
    @Value("${bloggito.github.password}")
    private String githubPassword;

    private String aaa;

    @PostConstruct
    public void initializaFirstData() {
        // First initialization of GithubData
        updateGithubData();
        // First initialization of StackOverflowData
        updateStackoverflowData();
    }

    @Override
    CrudRepository<UserDetail, Long> getRepository() {
        return userDao;
    }

    @Override
    public UserDetail findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Scheduled(cron = "${bloggito.github.update-interval}")
    @Override
    public void updateGithubData() {
        int attempts = 20;
        for (int i = 0; i < attempts; i++) {
            if (updateGithub()) {
                break;
            }
        }
    }

    @Scheduled(cron = "${bloggito.stackoverflow.update-interval}")
    @Override
    public void updateStackoverflowData() {
        try {
            userDao.findAll().forEach(user -> {
                if (user.getStackOverflowAccount().getStackOverflowId() != null) {
                    RestTemplate template = new RestTemplate();
                    // We need this factory to get gzip encoding supported
                    template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
                    StackOverflowDetail stackOverflowDetail = template.getForObject("https://api.stackexchange.com/2.2/users/"
                                    + user.getStackOverflowAccount().getStackOverflowId()
                                    + "?order=desc&sort=reputation&site=stackoverflow"
                            , StackOverflowDetail.class);
                    if (stackOverflowDetail.getItems().length > 0) {
                        StackOverflowDetail.Item item = stackOverflowDetail.getItems()[0];
                        user.getStackOverflowAccount().setBronze(item.getBadgeCounts().getBronze());
                        user.getStackOverflowAccount().setGold(item.getBadgeCounts().getGold());
                        user.getStackOverflowAccount().setSilver(item.getBadgeCounts().getSilver());
                        user.getStackOverflowAccount().setPoints(item.getReputation());
                    }
                    userDao.save(user);
                }
            });
        } catch (HttpMessageNotReadableException hmnre) {
            hmnre.printStackTrace();
        }
    }

    private boolean updateGithub() {
        try {
            String githubUrl = String.format("https://api.github.com/repos/%s/", githubUsername);
            userDao.findAll().forEach(user -> {
                RestTemplate template = new RestTemplate();
                GithubRepo[] repos = template.getForObject(String.format("https://api.github.com/users/%s/repos", githubUsername), GithubRepo[].class);
                user.getGithubAccount().setRepoCount(repos.length);
                user.getGithubAccount().setCommitCount(Arrays.stream(repos)
                        .map(GithubRepo::getName)
                        .mapToInt(repoName -> {
                            System.out.println("Deserializing " + githubUrl + repoName + "/stats/contributors");

                            ResponseEntity<GithubRepoDetail[]> contributions = new RestTemplate()
                                    .exchange(githubUrl
                                            + repoName + "/stats/contributors", HttpMethod.GET, new HttpEntity<GithubRepoDetail[]>(HttpUtils.createHeaders(githubUsername, githubPassword)), GithubRepoDetail[].class);

                            return Arrays.stream(contributions.getBody())
                                    .filter(detail -> user.getGithubAccount().getGithubId().equals(detail.getAuthorId()))
                                    .mapToInt(GithubRepoDetail::getTotal)
                                    .sum();
                        })
                        .sum());
                userDao.save(user);
            });
            return true;
        } catch (HttpMessageNotReadableException hmnre) {
            hmnre.printStackTrace();
            return false;
        }
    }
}