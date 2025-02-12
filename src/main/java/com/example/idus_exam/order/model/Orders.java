package com.example.idus_exam.order.model;

import com.example.idus_exam.member.model.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String orderNum;
    private String orderName;
    private LocalDateTime orderTime;

    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;


}
