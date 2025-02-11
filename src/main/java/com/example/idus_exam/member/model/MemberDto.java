package com.example.idus_exam.member.model;

import lombok.Getter;

public class MemberDto {

    @Getter
    public static class SignUpRequest {
        private String name;
        private String nickname;
        private String password;
        private String phoneNum;
        private String email;
        private String gender;

        public Member toEntity(String password) {
            return Member.builder()
                    .nickname(nickname)
                    .password(password)
                    .phoneNum(phoneNum)
                    .email(email)
                    .gender(gender)
                    .build();
        }
    }
}
