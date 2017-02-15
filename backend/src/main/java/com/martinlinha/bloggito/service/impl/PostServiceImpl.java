package com.martinlinha.bloggito.service.impl;

import com.martinlinha.bloggito.persistance.dao.PostDao;
import com.martinlinha.bloggito.persistance.entity.Post;
import com.martinlinha.bloggito.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by martinlinha on 23.01.17.
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public Iterable<Post> getAllPosts() {
        return postDao.findAll();
    }

    @Override
    public Post save(Post post) {
        return postDao.save(post);
    }

    @Override
    public Post findById(long id) {
        return postDao.findOne(id);
    }
}
