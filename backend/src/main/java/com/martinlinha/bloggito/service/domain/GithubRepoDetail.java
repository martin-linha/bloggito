package com.martinlinha.bloggito.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by martinlinha on 06.03.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepoDetail {
    private int total;
    private Author author;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getAuthorId() {
        if (author != null) {
            return author.getId();
        }
        return null;
    }

    static private class Author {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
