package com.example.springStudy;


import com.example.springStudy.repository.MemberRepository;
import com.example.springStudy.repository.MemoryMemberRepository;
import com.example.springStudy.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
