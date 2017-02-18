package com.martinlinha.bloggito.persistance.entity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import java.util.Date;

/**
 * Created by martinlinha on 23.01.17.
 */
@Entity
public class Post extends AbstractEntity {
    private String title;
    @Lob
    private String content;
    private String perex;
    private Date postedOn;
    @ManyToOne
    private Post creator;

    @PrePersist
    public void prePersist() {
        postedOn = new Date();
    }

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

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }
}
