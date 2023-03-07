package com.example.board.dto;

import com.example.board.Repository.PostsRepository;
import com.example.board.entity.Posts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostsDtoTest {


    @Autowired
    private PostsRepository postsRepository;

    public Posts createPosts() {
        Posts posts = new Posts();
        posts.setTitle("testTitle");
        posts.setContent("testContent");
        posts.setAuthor("testAuthor");
        return posts;
    }

    @Test
    public void testCreatePost() {
        Posts posts = createPosts();
        postsRepository.save(posts);
//
//        assertThat(posts.getCreatedDate()).isNotNull();
//        assertThat(posts.getModifiedDate()).isNotNull();
//        assertThat(posts.getCreatedDate()).isEqualTo(posts.getModifiedDate());

        System.out.println(posts.toString());
        System.out.println(posts.toString());
        System.out.println(posts.toString());
        System.out.println(posts.toString());
        System.out.println(posts.toString());
        System.out.println(posts.toString());
        System.out.println(posts.toString());
        System.out.println(posts.toString());
        System.out.println(posts.toString());
        System.out.println(posts.toString());
        System.out.println(posts.getCreatedDate().toString());
        System.out.println(posts.getModifiedDate());
        assertNotNull(posts.getId());
        assertNotNull(posts.getCreatedDate());
        assertNotNull(posts.getModifiedDate());
    }

//    @Test
//    public void testUpdatePost() {
//        Posts posts = new Posts();
//        posts.setTitle("Test Post");
//        posts.setContent("Test Content");
//        postsRepository.save(posts);
//
//        LocalDateTime createdAt = posts.getCreatedDate();
//        LocalDateTime updatedAt = posts.getModifiedDate();
//
//        posts.setTitle("Updated Post");
//        posts.setContent("Updated Content");
//        postsRepository.save(posts);
//
//        assertEquals(createdAt, posts.getCreatedDate());
//        assertNotEquals(updatedAt, posts.getModifiedDate());
//    }
}