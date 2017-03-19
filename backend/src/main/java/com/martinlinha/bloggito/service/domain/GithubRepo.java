package com.martinlinha.bloggito.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by martinlinha on 06.03.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
