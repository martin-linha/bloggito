package com.martinlinha.bloggito.service.impl;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.martinlinha.bloggito.persistance.dao.UserDao;
import com.martinlinha.bloggito.persistance.entity.UserDetail;
import com.martinlinha.bloggito.service.UserService;
import com.martinlinha.bloggito.service.domain.GithubRepo;
import com.martinlinha.bloggito.service.domain.GithubRepoDetail;
import com.martinlinha.bloggito.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

    private String aaa;

    @PostConstruct
    public void initializaFirstData() {
        // First initialization of GithubData
        updateGithubData();
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

    private boolean updateGithub() {
        try {
            userDao.findAll().forEach(user -> {
                RestTemplate template = new RestTemplate();
                GithubRepo[] repos = template.getForObject("https://api.github.com/users/martin-linha/repos", GithubRepo[].class);
                user.getGithubAccount().setRepoCount(repos.length);
                user.getGithubAccount().setCommitCount(Arrays.stream(repos)
                        .map(GithubRepo::getName)
                        .mapToInt(repoName -> {
                            // TODO: implement exception handling. When requested for the first time, endpoint returns empty response.
                            System.out.println("Deserializing https://api.github.com/repos/martin-linha/" + repoName + "/stats/contributors");

                            ResponseEntity<GithubRepoDetail[]> contributions = new RestTemplate()
                                    .exchange("https://api.github.com/repos/martin-linha/"
                                            + repoName + "/stats/contributors", HttpMethod.GET, new HttpEntity<GithubRepoDetail[]>(HttpUtils.createHeaders("martin-linha", "")), GithubRepoDetail[].class);

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