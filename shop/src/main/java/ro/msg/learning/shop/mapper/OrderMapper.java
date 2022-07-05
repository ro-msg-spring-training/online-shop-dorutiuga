package ro.msg.learning.shop.mapper;

import ro.msg.learning.shop.dto.AddressDTO;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.entity.Orders;

public class OrderMapper {


    public static Orders fromDtoToEntity(OrderDTO orderDTO) {
        Orders orders = new Orders();
        orders.setOrderedProducts(OrderDetailMapper.fromListDtoToListEntity(orderDTO.getProductsOrdered()));
        orders.setCreatedAt(orderDTO.getCreatedAT());
        orders.setAddressCountry(orderDTO.getDeliveryAddress().getAddressCountry());
        orders.setAddressCounty(orderDTO.getDeliveryAddress().getAddressCounty());
        orders.setAddressCity(orderDTO.getDeliveryAddress().getAddressCity());
        orders.setAddressStreet(orderDTO.getDeliveryAddress().getAddressStreet());
        return orders;
    }

    public static OrderDTO fromEntityToDto(Orders orders) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setProductsOrdered(OrderDetailMapper.fromListEntityToListDto(orders.getOrderedProducts()));
        orderDTO.setCreatedAT(orders.getCreatedAt());
        orderDTO.setDeliveryAddress(new AddressDTO(orders.getAddressCountry(), orders.getAddressCounty(), orders.getAddressCity(), orders.getAddressStreet()));
        return  orderDTO;
    }
}
