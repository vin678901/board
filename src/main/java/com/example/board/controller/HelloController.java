package com.example.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/board")
    public String helloBoard() {
        return "hello Board";
    }
}
