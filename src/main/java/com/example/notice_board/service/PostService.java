package com.example.notice_board.service;

import com.example.notice_board.domain.Post;
import com.example.notice_board.repository.PostDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostDao postDao;

    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    public void createPost(Post post) {
        postDao.add(post);
    }

    public Post getPost(Long id) {
        return postDao.findById(id);
    }

    public List<Post> getAllPosts() {
        return postDao.findAll();
    }
}
