package com.example.springStudy.repository;

import com.example.springStudy.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest{

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearAll();
    }

    @Test
    public void 저장테스트(){
        Member member = new Member();
        member.setAge(30L);
        member.setName("심영현");

        Member result = repository.save(member);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void id로찾기(){
        Member member = new Member();
        member.setAge(30L);
        member.setName("심영현");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void 이름으로찾기(){
        Member member = new Member();
        member.setAge(30L);
        member.setName("심영현");
        repository.save(member);

        Member result = repository.findByName(member.getName()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void 전부조회(){
        Member member1 = new Member();
        member1.setAge(30L);
        member1.setName("심영현");
        repository.save(member1);

        Member member2 = new Member();
        member2.setAge(27L);
        member2.setName("한수지");
        repository.save(member2);

        Member member3 = new Member();
        member3.setAge(1L);
        member3.setName("심가몽");
        repository.save(member3);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(3);
    }
}
