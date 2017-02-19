package com.martinlinha.bloggito.service;

import com.martinlinha.bloggito.persistance.entity.Post;

import java.util.List;

/**
 * Created by martinlinha on 23.01.17.
 */
public interface PostService extends AbstractCrudService<Post, Long> {

    List<Post> getPostsDateDesc();
}
