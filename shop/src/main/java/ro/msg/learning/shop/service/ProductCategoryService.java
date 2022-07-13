package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entity.ProductCategory;
import ro.msg.learning.shop.repository.ProductCategoryRepository;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {
    @Autowired
    private final ProductCategoryRepository productCategoryRepository;

    public void createProductCategory(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }

    public void deleteProductCategory() {
        productCategoryRepository.deleteAll();
    }
}
