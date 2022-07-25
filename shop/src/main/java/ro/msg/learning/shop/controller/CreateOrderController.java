package ro.msg.learning.shop.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(value = "/orders")
public class CreateOrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping(value = "/create", produces = {"application/json"})
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        Orders orderToCreate = orderService.createOrder(OrderMapper.fromDtoToEntity(orderDTO));
        OrderDTO orders = OrderMapper.fromEntityToDto(orderToCreate);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
