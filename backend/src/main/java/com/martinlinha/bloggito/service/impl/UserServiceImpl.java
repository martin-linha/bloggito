package com.martinlinha.bloggito.service.impl;

import com.martinlinha.bloggito.persistance.dao.UserDao;
import com.martinlinha.bloggito.persistance.entity.UserDetail;
import com.martinlinha.bloggito.service.UserService;
import com.martinlinha.bloggito.service.domain.GithubRepo;
import com.martinlinha.bloggito.service.domain.GithubRepoDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
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

    @Scheduled(cron = "00 00 * * *")
    @Override
    public void updateGithubData() {
        userDao.findAll().forEach(user -> {
            RestTemplate template = new RestTemplate();
            GithubRepo[] repos = template.getForObject("https://api.github.com/users/martin-linha/repos", GithubRepo[].class);
            user.getGithubAccount().setRepoCount(15);
            user.getGithubAccount().setCommitCount(Arrays.stream(repos)
                    .map(GithubRepo::getName)
                    .mapToInt(repoName -> {
                        GithubRepoDetail[] contributions = new RestTemplate()
                                .getForObject("https://api.github.com/repos/martin-linha/"
                                        + repoName + "/stats/contributors", GithubRepoDetail[].class);
                        return Arrays.stream(contributions)
                                .filter(detail -> user.getGithubAccount().getGithubId().equals(detail.getAuthor().getId()))
                                .mapToInt(GithubRepoDetail::getTotal)
                                .sum();
                    })
                    .sum());
            userDao.save(user);
        });
    }
}
