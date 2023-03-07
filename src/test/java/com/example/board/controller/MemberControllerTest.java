package com.example.board.controller;

import com.example.board.Repository.MemberRepository;
import com.example.board.dto.MemberDto;
import com.example.board.entity.Member;
import com.example.board.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class MemberControllerTest {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(String email, String password) {
        MemberDto memberDto = new MemberDto();
        memberDto.setEmail(email);
        memberDto.setName("박유빈");
        memberDto.setPassword(password);
        Member member = Member.createMember(memberDto, passwordEncoder);
        return memberService.saveMember(member);
    }

    @Test
    public void loginSuccessTest() throws Exception {
        String email = "test@test.com";
        String password = "1234";
        this.createMember(email, password);
        mockMvc.perform(formLogin().userParameter("email")
                        .loginProcessingUrl("/members/login")
                        .user(email).password(password))
                .andExpect(SecurityMockMvcResultMatchers.authenticated());
    }

    @Test
    public void loginFailTest() throws Exception {
        String email = "test@test.com";
        String password = "1234";
        this.createMember(email, password);
        mockMvc.perform(formLogin().userParameter("email")
                .loginProcessingUrl("/members/login")
                .user(email).password("12345")).andExpect(SecurityMockMvcResultMatchers.unauthenticated());
    }
}