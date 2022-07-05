package ro.msg.learning.shop.mapper;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.entity.Product;

@Component
public class ProductMapper {

    public static ProductDTO fromEntityToDto(Product product) {
        return new ProductDTO(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getWeight(),
                product.getImageUrl(),
                CategoryMapper.fromEntityToDto(product.getProductCategory()),
                SupplierMapper.fromEntityToDto(product.getSupplier())

        );
    }

    public static Product fromDtoToEntity(ProductDTO productDTO) {
        return new Product(
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getPrice(),
                productDTO.getWeight(),
                CategoryMapper.fromDtoToEntity(productDTO.getProductCategory()),
                productDTO.getImageUrl(),
                SupplierMapper.fromDtoToEntity(productDTO.getSupplier())
        );
    }
}

