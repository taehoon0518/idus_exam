package com.example.idus_exam.order;

import com.example.idus_exam.member.Member;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String orderName;
    private String orderAddress;
    private LocalDateTime orderTime;

    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;


}
