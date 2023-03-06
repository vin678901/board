//package com.example.board.Repository;
//
//import com.example.board.dto.MemberDto;
//import com.example.board.entity.Member;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.transaction.Transactional;
//
//@SpringBootTest
//@Transactional
//class MemberRepositoryTest {
//
//    @Autowired
//    MemberRepository memberRepository;
//
//    @Test
//    public void saveMemberTest() {
//
//        MemberDto memberDto = new MemberDto();
//        memberDto.setName("이름");
//        memberDto.setEmail("test@test.com");
//        memberDto.setPassword("1234");
//        Member savedMember = memberRepository.save(memberDto.toEntity());
////
////
////        Member member = Member.builder()
////                .name("이름")
////                .email("test@test.com")
////                .password("1234")
////                .build();
////        Member savedMember = memberRepository.save(member);
////
////
////        member.setName("zz");
////        member.setPassword("1234");
////        member.setEmail("test@test.com");
////
//        System.out.println(memberRepository.getById(savedMember.getId()));
//
//        Assertions.assertThat(memberDto.getName()).isEqualTo(savedMember.getName());
//        Assertions.assertThat(memberDto.getEmail()).isEqualTo(savedMember.getEmail());
//        Assertions.assertThat(memberDto.getPassword()).isEqualTo(savedMember.getPassword());
//
//    }
//
//
//}