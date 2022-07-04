package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.mapper.OrderMapper;
import ro.msg.learning.shop.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class CreateOrderController {

    private final OrderService orderService;

    @GetMapping()
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Orders> createOrder(@RequestBody OrderDTO orderDTO) {
        Orders orderToCreate = orderService.createOrder(OrderMapper.fromDtoToEntity(orderDTO));
        return new ResponseEntity<>(orderToCreate, HttpStatus.OK);
    }
}
