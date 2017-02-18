package com.martinlinha.bloggito.service;

import com.martinlinha.bloggito.persistance.entity.Comment;

/**
 * Created by martinlinha on 18.02.17.
 */
public interface CommentService {

    public Comment save(Comment comment);

    public Comment saveCommentToPost(Comment comment, Long id);
}
