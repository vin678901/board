package com.example.board.controller;

import com.example.board.dto.MemberDto;
import com.example.board.dto.PostsDto;
import com.example.board.entity.Member;
import com.example.board.entity.Posts;
import com.example.board.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping(value = "/posts")
@Controller
@RequiredArgsConstructor
public class PostsController {
    private final PostsService postsService;

    @GetMapping(value = "/create")
    public String savePosts(Model model) {
        model.addAttribute("postsDto", new PostsDto());
        return "posts/createForm";
    }

    @PostMapping(value = "/create")
    public String savePosts(@Valid PostsDto postsDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "posts/createForm";
        }

        try {
            Posts posts = Posts.createPosts(postsDto);
            postsService.savePosts(posts);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "posts/createForm";
        }
        return "redirect:/";
    }
}
