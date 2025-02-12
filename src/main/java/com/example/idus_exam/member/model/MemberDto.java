package com.example.idus_exam.member.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

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
    @Builder
    @Getter
    public static class ReadResponse {
        private String name;
        private String nickname;
        private String phoneNum;
        private String email;
        private String gender;

        public static ReadResponse from(Member member) {
            return ReadResponse.builder()
                    .name(member.getName())
                    .nickname(member.getNickname())
                    .phoneNum(member.getPhoneNum())
                    .email(member.getEmail())
                    .gender(member.getGender())
                    .build();

        }
    }
    @Getter
    @Builder
    public static class listResponse {
        String name;
        String nickname;
        String phoneNum;
        String email;
        String gender;
        public static listResponse from (Member member) {
            return listResponse.builder()
                    .name(member.getName())
                    .nickname(member.getNickname())
                    .phoneNum(member.getPhoneNum())
                    .email(member.getEmail())
                    .gender(member.getGender())
                    .build();
        }
    }
}
