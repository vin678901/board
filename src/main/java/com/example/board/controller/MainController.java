package com.example.board.controller;

import com.example.board.dto.PostsDto;
import com.example.board.entity.Posts;
import com.example.board.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final PostsService postsService;


    @GetMapping(value = "/")
    public String main(Model model) {
        List<Posts> postsList = postsService.findAll();
        model.addAttribute("postsList", postsList);
        return "main";
    }

    @GetMapping("/posts/{id}")
    public String view(@PathVariable Long id, Model model) {

        PostsDto postsDto = postsService.findById((long) id);
        Posts posts = Posts.createPosts(postsDto);
        model.addAttribute("posts", posts);//
        return "posts/view";
    }
}
