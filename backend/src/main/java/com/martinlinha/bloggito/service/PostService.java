package com.martinlinha.bloggito.service;

import com.martinlinha.bloggito.persistance.entity.Post;

import java.util.List;

/**
 * Created by martinlinha on 23.01.17.
 */
public interface PostService {

    public Iterable<Post> getAllPosts();

    public List<Post> getPostsDateDesc();

    public Post save(Post post);

    public Post findById(long id);

}
