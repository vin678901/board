package com.example.board.dto;

import com.example.board.Repository.PostsRepository;
import com.example.board.entity.Posts;
import com.example.board.service.PostsService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class PostsUpdateRequestDtoTest {

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    PostsService postsService;

    public Posts createPosts() {
        PostsDto postsDto = new PostsDto();
        postsDto.setTitle("testTitle");
        postsDto.setContent("testContent");
        postsDto.setAuthor("testAuthor");
        return Posts.createPosts(postsDto);
    }

    @Test
    public void update() throws Exception {
        Posts posts = createPosts();
        postsRepository.save(posts);

        String updatedTitle = "updatedTitle";
        String updatedContent = "updatedContent";
        PostsUpdateRequestDto postsUpdateRequestDto = PostsUpdateRequestDto.builder()
                .title(updatedTitle)
                .content(updatedContent)
                .build();

        postsService.update(posts.getId(), postsUpdateRequestDto);

        System.out.println(postsRepository.findById(posts.getId()).toString());
    }

}