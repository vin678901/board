package com.example.board.entity;

import com.example.board.dto.PostsDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "posts")
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)//text타입으로 데이터를 추출할 것이다
    private String content;

    @Column(nullable = false)
    private String author;


    public static Posts createPosts(PostsDto postsDto) {
        Posts posts = new Posts();
        posts.title = postsDto.getTitle();
        posts.content = postsDto.getContent();
        posts.author = postsDto.getAuthor();

        return posts;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
