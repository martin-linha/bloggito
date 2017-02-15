package com.martinlinha.bloggito.persistance.dao;

import com.martinlinha.bloggito.persistance.entity.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by martinlinha on 23.01.17.
 */
public interface PostDao extends CrudRepository<Post, Long> {


}
