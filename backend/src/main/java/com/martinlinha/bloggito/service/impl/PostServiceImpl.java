package com.martinlinha.bloggito.service.impl;

import com.martinlinha.bloggito.persistance.dao.PostDao;
import com.martinlinha.bloggito.persistance.entity.Post;
import com.martinlinha.bloggito.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by martinlinha on 23.01.17.
 */
@Service
public class PostServiceImpl extends AbstractCrudServiceImpl<Post, Long> implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    CrudRepository<Post, Long> getRepository() {
        return postDao;
    }

    @Override
    public List<Post> getPostsDateDesc() {
        return postDao.getPostsDateDesc();
    }
}
