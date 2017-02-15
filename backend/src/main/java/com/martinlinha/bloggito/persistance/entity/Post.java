package com.martinlinha.bloggito.persistance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;

/**
 * Created by martinlinha on 23.01.17.
 */
@Entity
public class Post extends AbstractEntity {
    private String title;
    private String content;
    private String perex;
    @ManyToOne
    private Post creator;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPerex() {
        return perex;
    }

    public void setPerex(String perex) {
        this.perex = perex;
    }
}
