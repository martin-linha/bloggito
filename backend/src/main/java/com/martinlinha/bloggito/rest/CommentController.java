package com.martinlinha.bloggito.rest;

import com.martinlinha.bloggito.persistance.entity.Comment;
import com.martinlinha.bloggito.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by martinlinha on 18.02.17.
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/posts/{id}/comment")
    @ResponseStatus(HttpStatus.OK)
    public Comment addCommentToPost(@RequestBody Comment comment, @PathVariable Long id) {
        return commentService.saveCommentToPost(comment, id);
    }
}
