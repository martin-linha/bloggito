package com.martinlinha.bloggito.service;

import java.io.Serializable;

/**
 * Created by martinlinha on 19.02.17.
 */
public interface AbstractCrudService<T, U extends Serializable> {

    Iterable<T> findAll();

    T save(T t);

    T findById(U u);
}
