package com.example.board.controller;

import com.example.board.Repository.MemberRepository;
import com.example.board.dto.MemberDto;
import com.example.board.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping(value = "/new")
    public String member(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "member/memberForm";
    }

    @PostMapping(value = "/new")
    public String member(MemberDto memberDto) {
        Member member = Member.builder()
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .password(memberDto.getPassword())
                .build();

        memberRepository.save(member);

        return "redirect:/";
    }
}
