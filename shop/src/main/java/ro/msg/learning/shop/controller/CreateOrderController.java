package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.mapper.OrderMapper;
import ro.msg.learning.shop.service.OrderService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class CreateOrderController {

    private final OrderService orderService;


    @PostMapping("/create")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        Orders orderToCreate = orderService.createOrder(OrderMapper.fromDtoToEntity(orderDTO));
        OrderDTO orders = OrderMapper.fromEntityToDto(orderToCreate);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
