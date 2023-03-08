package com.example.board.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PostsDto {
    @NotEmpty(message = "제목을 입력해 주세요.")
    private String title;
    @NotEmpty(message = "내용을 입력해 주세요.")
    private String content;
    @NotEmpty(message = "작성자를 입력해 주세요.")
    private String author;


}
