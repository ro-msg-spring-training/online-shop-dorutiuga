package ro.msg.learning.shop.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.CategoryDTO;
import ro.msg.learning.shop.entity.ProductCategory;

@Component
@NoArgsConstructor
public class CategoryMapper {
    public static CategoryDTO fromEntityToDto(ProductCategory productCategory){
        return new CategoryDTO(
                productCategory.getId(),
                productCategory.getName(),
                productCategory.getDescription()
        );
    }
    public static ProductCategory fromDtoToEntity(CategoryDTO categoryDTO){
        return new ProductCategory(
                categoryDTO.getId(),
                categoryDTO.getName(),
                categoryDTO.getDescription()
        );
    }
}
