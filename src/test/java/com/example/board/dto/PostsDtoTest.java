package com.example.board.dto;

import com.example.board.Repository.PostsRepository;
import com.example.board.entity.Posts;
import com.example.board.service.PostsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostsDtoTest {


    @Autowired
    PostsService postsService;
    @Autowired
    private PostsRepository postsRepository;

    public Posts createPosts() {
        PostsDto postsDto = new PostsDto();
        postsDto.setTitle("testTitle");
        postsDto.setContent("testContent");
        postsDto.setAuthor("testAuthor");
        return Posts.createPosts(postsDto);
    }

    @Test
    public void testCreatePost() {
        Posts posts = createPosts();
        //postsRepository.save(posts);
        postsService.savePosts(posts);
        System.out.println(posts.toString());
        assertNotNull(posts.getId());
        assertNotNull(posts.getAuthor());
        assertNotNull(posts.getTitle());
        assertNotNull(posts.getContent());
        assertNotNull(posts.getCreatedDate());
        assertNotNull(posts.getModifiedDate());
    }

}