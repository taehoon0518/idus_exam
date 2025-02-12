package com.example.idus_exam.order;

import com.example.idus_exam.order.model.OrdersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;

    @GetMapping("/{idx}")
    public ResponseEntity<List<OrdersDto.OrderResponse>> readOrderByIdx(@PathVariable Long idx) {
        List<OrdersDto.OrderResponse> dto = ordersService.readOrder(idx);
        return ResponseEntity.ok(dto);
    }
}
