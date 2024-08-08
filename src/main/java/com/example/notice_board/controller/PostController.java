package com.example.notice_board.controller;

import com.example.notice_board.domain.Post;
import com.example.notice_board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping //글 추가
    public void addPost(@RequestBody Post post) {
        postService.createPost(post);
    }

    @GetMapping("/{id}") //글 id로 조회
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @GetMapping //글 전체 조회
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}

