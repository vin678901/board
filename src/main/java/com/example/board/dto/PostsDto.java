package com.example.board.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PostsDto {
    @NotBlank(message = "제목을 입력해 주세요.")
    private String title;
    @NotBlank(message = "내용을 입력해 주세요.")
    private String content;
    @NotBlank(message = "작성자를 입력해 주세요.")
    private String author;


}
