package com.example.board.service;

import com.example.board.Repository.PostsRepository;
import com.example.board.entity.Posts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    public Posts savePosts(Posts posts) {
        return postsRepository.save(posts);
    }

}
