package com.martinlinha.bloggito.service.impl;

import com.martinlinha.bloggito.service.AbstractCrudService;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * Created by martinlinha on 19.02.17.
 */
public abstract class AbstractCrudServiceImpl<T, U extends Serializable> implements AbstractCrudService<T, U> {

    @Override
    public Iterable<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T save(T t) {
        return getRepository().save(t);
    }

    @Override
    public T findById(U u) {
        return getRepository().findOne(u);
    }

    abstract CrudRepository<T, U> getRepository();
}
