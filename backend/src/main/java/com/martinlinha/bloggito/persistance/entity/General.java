package com.martinlinha.bloggito.persistance.entity;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import java.util.Date;

/**
 * Created by martinlinha on 19.02.17.
 */
@Entity
public class General extends AbstractEntity {
    private String location;
    private String email;
    private String homepage;
    private Date createdOn;

    @PrePersist
    public void prePersist() {
        createdOn = new Date();
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getLocation() {
        return location;

    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
}
