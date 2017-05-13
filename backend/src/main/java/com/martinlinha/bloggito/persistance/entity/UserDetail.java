package com.martinlinha.bloggito.persistance.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by martinlinha on 07.02.17.
 */
@Entity
public class UserDetail extends AbstractEntity {

    private String name;
    private String email;
    private String password;
    private String createdOn;
    @OneToMany(mappedBy = "creator")
    private List<Post> posts;
    @OneToMany(mappedBy = "userDetail")
    private List<Comment> comments;
    @Embedded
    private GithubAccount githubAccount;
    @Embedded
    private StackOverflowAccount stackOverflowAccount;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public GithubAccount getGithubAccount() {
        if (githubAccount == null) {
            githubAccount = new GithubAccount();
        }
        return githubAccount;
    }

    public void setGithubAccount(GithubAccount githubAccount) {
        this.githubAccount = githubAccount;
    }

    public StackOverflowAccount getStackOverflowAccount() {
        if (stackOverflowAccount == null) {
            stackOverflowAccount = new StackOverflowAccount();
        }
        return stackOverflowAccount;
    }

    public void setStackOverflowAccount(StackOverflowAccount stackOverflowAccount) {
        this.stackOverflowAccount = stackOverflowAccount;
    }
}
