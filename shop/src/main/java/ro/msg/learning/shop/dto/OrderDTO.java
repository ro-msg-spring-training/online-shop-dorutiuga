package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDTO {

    private List<OrderDetailDTO> productsOrdered;

    private LocalDateTime createdAT;

    private AddressDTO deliveryAddress;
}
