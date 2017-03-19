package com.martinlinha.bloggito.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by martinlinha on 06.03.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepoDetail {
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
