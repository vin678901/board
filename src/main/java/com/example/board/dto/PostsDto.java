package com.example.board.dto;

import com.example.board.entity.Posts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostsDto {
    @NotEmpty(message = "제목을 입력해 주세요.")
    private String title;
    @NotEmpty(message = "내용을 입력해 주세요.")
    private String content;
    @NotEmpty(message = "작성자를 입력해 주세요.")
    private String author;

    public PostsDto(Posts entity) {
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
