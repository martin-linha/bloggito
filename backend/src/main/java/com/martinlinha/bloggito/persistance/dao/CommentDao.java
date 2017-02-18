package com.martinlinha.bloggito.persistance.dao;

import com.martinlinha.bloggito.persistance.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by martinlinha on 18.02.17.
 */
public interface CommentDao extends CrudRepository<Comment, Long> {

}
