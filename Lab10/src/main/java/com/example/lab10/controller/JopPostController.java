package com.example.lab10.controller;

import com.example.lab10.model.JopPost;
import com.example.lab10.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/system/post")
public class JopPostController {
    private final PostService postService;

    @GetMapping("/get")
    public ResponseEntity<?> getPosts() {
        return ResponseEntity.status(200).body(postService.getAllPosts());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPost(@Valid @RequestBody JopPost jopPost, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        postService.AddPost(jopPost);
        return ResponseEntity.status(200).body("added");

    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePost(@PathVariable Integer Id, @RequestBody @Valid JopPost jopPost, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean IsUpdated = postService.updatePost(Id, jopPost);
        if (!IsUpdated) {
            return ResponseEntity.status(400).body("Post not found");
        }
        return ResponseEntity.status(200).body("updated");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePost(@PathVariable Integer Id) {
        boolean isDeleted = postService.deletePost(Id);
        if (!isDeleted) {
            return ResponseEntity.status(400).body("User not found");
        }
        return ResponseEntity.status(200).body("User deleted");


    }

}
