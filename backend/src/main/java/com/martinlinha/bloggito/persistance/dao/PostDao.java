package com.martinlinha.bloggito.persistance.dao;

import com.martinlinha.bloggito.persistance.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by martinlinha on 23.01.17.
 */
public interface PostDao extends CrudRepository<Post, Long> {

    @Query("select p from Post p order by p.postedOn desc")
    public List<Post> getPostsDateDesc();

}
