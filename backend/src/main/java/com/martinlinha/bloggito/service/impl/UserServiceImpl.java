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
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by martinlinha on 20.02.17.
 */
@Service
public class UserServiceImpl extends AbstractCrudServiceImpl<UserDetail, Long> implements UserService {

    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void initializaFirstData() {
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

    @Transactional
    @Scheduled(cron = "00 00 * * *")
    @Override
    public void updateGithubData() {
        System.out.println("hey.");
        System.out.println(userDao.count());
        userDao.findAll().forEach(user -> {
            RestTemplate template = new RestTemplate();
            GithubRepo[] repos = template.getForObject("https://api.github.com/users/martin-linha/repos", GithubRepo[].class);
            user.getGithubAccount().setRepoCount(repos.length);
            System.out.println("SETTING repo count " + repos.length);
            long commitCount = Arrays.stream(repos)
                    .map(GithubRepo::getName)
                    .mapToInt(repoName -> {
                            System.out.println("https://api.github.com/repos/martin-linha/"
                                    + repoName + "/stats/contributors");
                            return new RestTemplate()
                                    .getForObject("https://api.github.com/repos/martin-linha/"
                                            + repoName + "/stats/contributors", GithubRepoDetail.class).getTotal();
                    })
                    .sum();
            System.out.println("@@@@@@@@@ " + commitCount);
        });
    }
}
