package com.martinlinha.bloggito.persistance.entity;

import javax.persistence.Embeddable;

/**
 * Created by martinlinha on 06.03.17.
 */
@Embeddable
public class GithubAccount {
    private Integer repoCount;
    private Integer commitCount;

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
