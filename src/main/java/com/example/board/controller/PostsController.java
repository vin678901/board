package com.example.board.controller;

import com.example.board.dto.PostsDto;
import com.example.board.dto.PostsUpdateRequestDto;
import com.example.board.entity.Posts;
import com.example.board.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/posts")
@Controller
@RequiredArgsConstructor
public class PostsController {
    private final PostsService postsService;

    @GetMapping(value = "/create")
    public String getSavePosts(Model model) {
        model.addAttribute("postsDto", new PostsDto());
        return "posts/createForm";
    }

    @PostMapping(value = "/create")
    public String postSavePosts(@Valid PostsDto postsDto, BindingResult bindingResult, Model model) {

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


    @GetMapping(value = "/update/{id}")
    public String getUpdatePosts(@PathVariable Long id, Model model) {
        PostsDto postsDto = postsService.findById(id);
        PostsUpdateRequestDto requestDto = new PostsUpdateRequestDto();
        requestDto.setTitle(postsDto.getTitle());
        requestDto.setContent(postsDto.getContent());
        model.addAttribute("requestDto", requestDto);
        model.addAttribute("id", id);
        return "posts/updateForm";
    }


    @PostMapping(value = "/update/{id}")
    public String putUpdatePosts(@PathVariable Long id, @ModelAttribute("requestDto") @Valid PostsUpdateRequestDto requestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "posts/updateForm";
        }
        postsService.update(id, requestDto);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deletePost(@RequestParam("id") Long id) {
        postsService.deletePost(id);
        return "redirect:/";
    }
}
