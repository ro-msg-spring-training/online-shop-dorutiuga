package ro.msg.learning.shop.mapper;

import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.entity.Orders;

import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDTO fromEntityToDto(Orders order) {

        return new OrderDTO(
                order.getOrderedProducts()
                        .stream()
                        .map(OrderDetailMapper::fromEntityToDto)
                        .collect(Collectors.toList()),
                order.getCreatedAt(),

                AddressMapper.fromEntityToDto(order.getAddressCountry(),
                        order.getAddressCounty(),
                        order.getAddressCity(),
                        order.getAddressStreet())

        );

    }

    public static Orders fromDtoToEntity(OrderDTO orderDTO) {
        return new Orders(

                orderDTO.getProductsOrdered(),
                orderDTO.getCreatedAT(),
                orderDTO.getDeliveryAddress()
        );
    }

}
