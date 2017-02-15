package com.martinlinha.bloggito.rest;

import com.martinlinha.bloggito.persistance.entity.Post;
import com.martinlinha.bloggito.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by martinlinha on 22.01.17.
 */
@RestController
public class ApiController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/posts")
    public Iterable<Post> getPosts() {
        return postService.getAllPosts();
    }

    @PostMapping(value = "/posts")
    @ResponseStatus(HttpStatus.OK)
    public void addPost(@RequestBody Post post) {
        postService.save(post);
    }

    @GetMapping(value = "/posts/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.findById(id);
    }
}
