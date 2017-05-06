package com.martinlinha.bloggito.rest;

import com.martinlinha.bloggito.persistance.entity.Comment;
import com.martinlinha.bloggito.persistance.entity.Post;
import com.martinlinha.bloggito.service.CommentService;
import com.martinlinha.bloggito.service.PostService;
import com.martinlinha.bloggito.service.auth.annotation.JwtSecured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Created by martinlinha on 22.01.17.
 */
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/posts")
    public Iterable<Post> getPosts() {
        return postService.getPostsDateDesc();
    }

    @PostMapping(value = "/posts")
    @JwtSecured
    public Post addPost(@RequestBody Post post) {
        return postService.save(post);
    }

    @GetMapping(value = "/posts/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.findById(id);
    }
}
