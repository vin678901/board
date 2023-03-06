package com.example.board.entity;

import com.example.board.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "member")
@NoArgsConstructor
@Data
@AllArgsConstructor
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

    //    @Builder
//    public Member(String name, String email, String password) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//    }
    public static Member createMember(MemberDto memberDto) {
        Member member = new Member();
        member.setName(memberDto.getName());
        member.setEmail(memberDto.getEmail());
        member.setPassword(memberDto.getPassword());
        return member;
    }
}
