package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.entity.Location;

import java.util.List;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OrderSchedulerDTO {
    private Location location;
    private Integer orderId;
    private List<OrderDetailDTO> orderedProducts;
    private String addressCity;
    private String addressCountry;
    private String addressCounty;
    private String addressStreet;
}
