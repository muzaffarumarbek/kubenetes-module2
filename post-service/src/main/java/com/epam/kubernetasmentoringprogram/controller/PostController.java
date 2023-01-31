package com.epam.kubernetasmentoringprogram.controller;

import com.epam.kubernetasmentoringprogram.entity.Post;
import com.epam.kubernetasmentoringprogram.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Post post) {
        postService.create(post);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @GetMapping("/list")
    public ResponseEntity<?> get() {
        List<Post> posts = postService.getPosts();
        return ResponseEntity.ok(posts);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }
}
