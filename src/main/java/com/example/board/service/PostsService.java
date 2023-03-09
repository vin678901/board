package com.example.board.service;

import com.example.board.Repository.PostsRepository;
import com.example.board.dto.PostsDto;
import com.example.board.entity.Posts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsService {


    private final PostsRepository postsRepository;

    public Posts savePosts(Posts posts) {
        return postsRepository.save(posts);
    }

    public List<Posts> findAll() {
        return postsRepository.findAll();
    }

    public PostsDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsDto(entity);
    }

}
