package com.example.idus_exam.member;

import com.example.idus_exam.member.model.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/verify")
    public void verify(String uuid) {
        memberService.verify(uuid);
    }

    @PostMapping("/signup")
    public void signup(@RequestBody MemberDto.SignUpRequest dto) {
        memberService.signup(dto);
    }
}
