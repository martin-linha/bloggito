package com.martinlinha.bloggito.persistance.entity;

import javax.persistence.*;

/**
 * Created by martinlinha on 23.01.17.
 */
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
