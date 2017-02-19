package com.martinlinha.bloggito.service;

import com.martinlinha.bloggito.persistance.entity.Comment;

/**
 * Created by martinlinha on 18.02.17.
 */
public interface CommentService extends AbstractCrudService<Comment, Long> {

    Comment saveCommentToPost(Comment comment, Long id);
}
