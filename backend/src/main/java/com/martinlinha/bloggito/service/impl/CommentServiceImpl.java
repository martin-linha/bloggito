package com.martinlinha.bloggito.service.impl;

import com.martinlinha.bloggito.persistance.dao.CommentDao;
import com.martinlinha.bloggito.persistance.dao.PostDao;
import com.martinlinha.bloggito.persistance.entity.Comment;
import com.martinlinha.bloggito.persistance.entity.Post;
import com.martinlinha.bloggito.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by martinlinha on 18.02.17.
 */
@Service
public class CommentServiceImpl extends AbstractCrudServiceImpl<Comment, Long> implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private PostDao postDao;

    @Override
    CrudRepository<Comment, Long> getRepository() {
        return commentDao;
    }

    @Transactional
    @Override
    public Comment saveCommentToPost(Comment comment, Long id) {
        Post post = postDao.findOne(id);
        comment.setPost(post);
        post.getComments().add(comment);
        return comment;
    }
}
