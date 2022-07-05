package ro.msg.learning.shop.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.CategoryDTO;
import ro.msg.learning.shop.entity.ProductCategory;

@Component
@NoArgsConstructor
public class CategoryMapper {
    public static CategoryDTO fromEntityToDto(ProductCategory productCategory) {
        return new CategoryDTO(
                productCategory.getId()

        );
    }

    public static ProductCategory fromDtoToEntity(CategoryDTO categoryDTO) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(categoryDTO.getId());
        return productCategory;
    }
}
