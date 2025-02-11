package com.example.idus_exam.member;

import com.example.idus_exam.member.model.MemberDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{idx}")
    public ResponseEntity<MemberDto.ReadResponse> details(@PathVariable int idx) {
        MemberDto.ReadResponse response = memberService.details(idx);
        return ResponseEntity.ok(response);
    }
}
