package ro.msg.learning.shop.mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ro.msg.learning.shop.dto.OrderDetailDTO;
import ro.msg.learning.shop.entity.OrderDetail;

public  class OrderDetailMapper {

    public static OrderDetailDTO fromEntityToDto(OrderDetail orderDetail){
        return new OrderDetailDTO(
                orderDetail.getId(),
                orderDetail.getQuantity()

        );
    }

    public static OrderDetail fromDtoToEntity(OrderDetailDTO orderDetail){
        return new OrderDetail(

                orderDetail.getProductId(),
                orderDetail.getQuantity()
                );
    }
}
