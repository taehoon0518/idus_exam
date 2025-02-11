package com.example.idus_exam.member;

import com.example.idus_exam.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String username);
    Optional<Member> findByIdx(int idx);
}
