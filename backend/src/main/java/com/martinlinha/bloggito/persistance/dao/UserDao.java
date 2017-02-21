package com.martinlinha.bloggito.persistance.dao;

import com.martinlinha.bloggito.persistance.entity.UserDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by martinlinha on 20.02.17.
 */
public interface UserDao extends CrudRepository<UserDetail, Long> {

    UserDetail findByEmail(String email);
}
