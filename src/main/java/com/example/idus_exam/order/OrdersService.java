package com.example.idus_exam.order;

import com.example.idus_exam.order.model.Orders;
import com.example.idus_exam.order.model.OrdersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;
    public List<OrdersDto.OrderResponse> readOrder(Long idx) {
        List<Orders> orders = ordersRepository.findByMemberIdx(idx);
        List<OrdersDto.OrderResponse> resp = new ArrayList<>();
        for (Orders order : orders) {
            OrdersDto.OrderResponse dto = OrdersDto.OrderResponse.from(order);
            resp.add(dto);
        }
        return resp;
    }
}
