package me.hugh.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public void test(){
        // 생성(create)
        memberRepository.save(new Member(1L,"A"));

        // 조회(read)
        Optional<Member> member = memberRepository.findById(1L);
        List<Member> members = memberRepository.findAll();

        // 삭제(delete)
        memberRepository.deleteById(1L);
    }
}
