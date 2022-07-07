package ro.msg.learning.shop.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonPropertyOrder({"locationName", "productName", "quantity"})
public class StockDTO {

    private String locationName;
    private String productName;
    private Integer quantity;
}
