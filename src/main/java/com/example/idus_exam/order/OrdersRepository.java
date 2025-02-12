package com.example.idus_exam.order;

import com.example.idus_exam.order.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByMemberIdx(Long idx);
}
