package com.martinlinha.bloggito.persistance.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Type;
import org.springframework.transaction.annotation.Transactional;

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
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String content;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String perex;
    private Date postedOn;
    @ManyToOne
    private Post creator;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
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
