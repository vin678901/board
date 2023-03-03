package com.example.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "member")
@NoArgsConstructor
@Getter//Setter는 사용하지 않는다. 빌더를 사용할 것이기 때문
//엔티티는 db와 직접 닿는 부분이기 때문에 DTO를 이용하여 데이터를 변경해 주저야 한다.
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//AUTO, IDENTITY, SEQUENCE, TABLE이 있다
    //유저 간 구분을 위해 AUTO_INCREMENT를 사용할 것이다
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Builder
    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
