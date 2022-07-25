package ro.msg.learning.shop.mapper;

import ro.msg.learning.shop.dto.OrderSchedulerDTO;
import ro.msg.learning.shop.entity.Orders;

import java.util.ArrayList;
import java.util.List;

public class OrderSchedulerMapper {

    public static OrderSchedulerDTO fromEntityToDto(Orders orders){
        return  OrderSchedulerDTO.builder()
                .orderId(orders.getId())
                .orderedProducts(OrderDetailMapper.fromListEntityToListDto(orders.getOrderedProducts()))
                .location(orders.getShippedFrom())
                .addressCity(orders.getAddressCity())
                .addressCountry(orders.getAddressCountry())
                .addressCounty(orders.getAddressCounty())
                .addressStreet(orders.getAddressStreet())
                .build();
    }

    public static List< OrderSchedulerDTO> fromEntityListToDtoList(List<Orders> ordersList){
        List<OrderSchedulerDTO> result = new ArrayList<>();
        for (Orders order : ordersList){
            result.add(fromEntityToDto(order));
        }
        return result;
    }
}
