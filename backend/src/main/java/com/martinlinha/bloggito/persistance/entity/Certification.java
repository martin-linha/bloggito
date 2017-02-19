package com.martinlinha.bloggito.persistance.entity;

import javax.persistence.Entity;

/**
 * Created by martinlinha on 19.02.17.
 */
@Entity
public class Certification extends AbstractEntity {
    private String title;
    private String license;
    private String img;
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
