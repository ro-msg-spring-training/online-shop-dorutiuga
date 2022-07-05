package ro.msg.learning.shop.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.dto.OrderDetailDTO;
import ro.msg.learning.shop.entity.OrderDetail;
import ro.msg.learning.shop.entity.Product;
import ro.msg.learning.shop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailMapper {
    @Autowired
    private ProductRepository productRepository;

    public static OrderDetail fromDtoToEntity(OrderDetailDTO orderDetailDTO) {
        Product product = new Product();
        product.setId(orderDetailDTO.getProductId());

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProduct(product);
        orderDetail.setQuantity(orderDetailDTO.getQuantity());
        return orderDetail;
    }

    public static OrderDetailDTO fromEntityToDto(OrderDetail orderDetail) {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setProductId(orderDetail.getProduct().getId());
        orderDetailDTO.setQuantity(orderDetail.getQuantity());
        return orderDetailDTO;
    }


    public static List<OrderDetail> fromListDtoToListEntity(List<OrderDetailDTO> orderDetailListDTO) {
        List<OrderDetail> orderDetail = new ArrayList<>();
        for (OrderDetailDTO createdOrderedDetailDTO : orderDetailListDTO) {
            orderDetail.add(fromDtoToEntity(createdOrderedDetailDTO));
        }
        return orderDetail;
    }

    public static List<OrderDetailDTO> fromListEntityToListDto(List<OrderDetail> orderDetailList) {
        List<OrderDetailDTO> orderDetailDTO = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetailList) {
            OrderDetailDTO crtOrderDetailDTO = fromEntityToDto(orderDetail);
            crtOrderDetailDTO.setProductId(orderDetail.getProduct().getId());
            orderDetailDTO.add(crtOrderDetailDTO);
        }
        return orderDetailDTO;
    }


}
