package com.martinlinha.bloggito.service;

import com.martinlinha.bloggito.persistance.entity.UserDetail;

/**
 * Created by martinlinha on 20.02.17.
 */
public interface UserService extends AbstractCrudService<UserDetail, Long> {

    UserDetail findByEmail(String email);
}
