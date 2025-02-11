package com.example.idus_exam.member;

import com.example.idus_exam.order.Orders;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String name;
    private String nickname;
    private String password;
    private int phoneNum;
    private String email;
    private String gender;

    @OneToMany(mappedBy = "member")
    private List<Orders> orders;
}
