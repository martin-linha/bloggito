package com.martinlinha.bloggito.persistance.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by martinlinha on 06.03.17.
 */
@Embeddable
public class GithubAccount {
    private Integer repoCount;
    private Integer commitCount;
    private String githubId;
    @Column(name = "github_username")
    private String username;
    @Column(name = "github_password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGithubId() {
        return githubId;
    }

    public void setGithubId(String githubId) {
        this.githubId = githubId;
    }

    public Integer getRepoCount() {
        return repoCount;
    }

    public void setRepoCount(Integer repoCount) {
        this.repoCount = repoCount;
    }

    public Integer getCommitCount() {
        return commitCount;
    }

    public void setCommitCount(Integer commitCount) {
        this.commitCount = commitCount;
    }
}
