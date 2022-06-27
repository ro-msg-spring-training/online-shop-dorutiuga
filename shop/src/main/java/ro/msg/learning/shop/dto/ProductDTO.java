package ro.msg.learning.shop.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ProductDTO {

    private String name;
    private String description;
    private double price;
    private double weight;
    private String imageUrl;
    private CategoryDTO productCategory;
    private SupplierDTO supplier;

}
