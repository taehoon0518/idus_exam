package com.example.idus_exam.order.model;

import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class OrdersDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class OrderResponse{
        private String orderNum;
        private String orderName;
        private LocalDateTime orderTime;

        public static OrderResponse from (Orders order){
            return OrderResponse.builder()
                    .orderNum(order.getOrderNum())
                    .orderName(order.getOrderName())
                    .orderTime(order.getOrderTime())
                    .build();

        }
    }
}
