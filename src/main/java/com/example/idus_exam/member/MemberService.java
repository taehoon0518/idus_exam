package com.example.idus_exam.member;

import com.example.idus_exam.emailverify.EmailVerifyService;
import com.example.idus_exam.member.model.Member;
import com.example.idus_exam.member.model.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailVerifyService emailVerifyService;

    @Transactional
    public void signup(MemberDto.SignUpRequest dto) {
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        Member member = memberRepository.save(dto.toEntity(encodedPassword));
        emailVerifyService.signup(member.getIdx(), member.getEmail());

    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> result = memberRepository.findByEmail(username);

        if (result.isPresent()) {
            // 7번 로직
            Member member = result.get();
            return member;
        }
        return null;
    }

    @Transactional
    public void verify(String uuid) {
        Member member = emailVerifyService.verify(uuid);
        if(member != null) {
            member.verify();
            memberRepository.save(member);
        }
    }

    @Transactional(readOnly = true)
    public MemberDto.ReadResponse details(int idx) {
        Member member = memberRepository.findByIdx(idx).orElseThrow();
        return MemberDto.ReadResponse.from(member);
    }
}
