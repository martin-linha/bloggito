package com.martinlinha.bloggito.persistance.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;

/**
 * Created by martinlinha on 23.01.17.
 */
@Entity
public class Post extends AbstractEntity {
    private String title;
    @Column(length = 100000)
    private String content;
    private String perex;
    private Date postedOn;
    @ManyToOne
    private Post creator;
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    @OrderBy("createdOn desc")
    private List<Comment> comments;

    public Post getCreator() {
        return creator;
    }

    public void setCreator(Post creator) {
        this.creator = creator;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

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
