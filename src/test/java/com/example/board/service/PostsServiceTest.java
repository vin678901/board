package com.example.board.service;

import com.example.board.Repository.PostsRepository;
import com.example.board.dto.MemberDto;
import com.example.board.dto.PostsDto;
import com.example.board.entity.Member;
import com.example.board.entity.Posts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostsServiceTest {

    @Autowired
    PostsService postsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    MemberService memberService;

    public Posts createPosts() {
        PostsDto postsDto = new PostsDto();
        postsDto.setTitle("testTitle");
        postsDto.setContent("testContent");
        postsDto.setAuthor("testAuthor");
        return Posts.createPosts(postsDto);
    }

    public Member createMember() {
        MemberDto memberDto = new MemberDto();
        memberDto.setEmail("test@testt.com");
        memberDto.setName("박유빈zzzz");
        memberDto.setPassword("1234");
        return Member.createMember(memberDto, passwordEncoder);
    }

    @Test
    public void findByIdTest() {
        Member member = createMember();
        memberService.saveMember(member);
        System.out.println(postsService.findById((long) 1).toString());
        System.out.println(postsService.findById((long) 1).toString());
        System.out.println(postsService.findById((long) 1).toString());
        System.out.println(postsService.findById((long) 1).toString());
        System.out.println(postsService.findById((long) 1).toString());
        System.out.println(postsService.findById((long) 1).toString());
        System.out.println(postsService.findById((long) 1).toString());
        System.out.println(postsService.findById((long) 1).toString());
        System.out.println(postsService.findById((long) 1).toString());
        System.out.println(postsService.findById((long) 1).toString());
        System.out.println(postsService.findById((long) 1).toString());
        System.out.println(postsService.findById((long) 1).toString());
        System.out.println(postsService.findById((long) 1).toString());
        System.out.println(postsService.findById((long) 1).toString());
        System.out.println(postsService.findById((long) 1).toString());
    }

    @Test
    public void myTest() {
        Long id = 1L;
        PostsDto postsDto = postsService.findById((long) id);
        Posts posts = Posts.createPosts(postsDto);
        System.out.println(posts.getId());
        System.out.println(posts.getId());
        System.out.println(posts.getId());
        System.out.println(posts.getId());
        System.out.println(posts.getId());
        System.out.println(posts.getId());
        System.out.println(posts.getId());
        System.out.println(posts.getId());
        System.out.println(posts.getModifiedDate());
        System.out.println(posts.getModifiedDate());
        System.out.println(posts.getModifiedDate());
        System.out.println(posts.getModifiedDate());
        System.out.println(posts.getModifiedDate());
        System.out.println(posts.getModifiedDate());
        System.out.println(posts.getModifiedDate());
        System.out.println(posts.getModifiedDate());
    }

    @Test
    @Transactional
    public void deleteTest() {
        Posts posts = createPosts();
        postsService.savePosts(posts);

        postsService.deletePost(posts.getId());
        Optional<Posts> deletedPosts = postsRepository.findById(posts.getId());

        assertFalse(deletedPosts.isPresent());

    }
}