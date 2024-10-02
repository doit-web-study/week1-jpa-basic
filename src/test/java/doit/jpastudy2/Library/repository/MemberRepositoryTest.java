package doit.jpastudy2.Library.repository;

import doit.jpastudy2.Library.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void test(){
        Member member = Member.builder()
                .name("문소현")
                .email("sohyun22@ajou.ac.kr")
                .phone("01012345678")
                .joinDate(LocalDate.now())
                .build();

        memberRepository.save(member);

        Member member1 = memberRepository.findByName("문소현");

        System.out.println("name = " + member1.getEmail());
    }
}