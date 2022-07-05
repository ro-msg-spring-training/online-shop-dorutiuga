package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.entity.Product;
import ro.msg.learning.shop.mapper.CategoryMapper;
import ro.msg.learning.shop.mapper.ProductMapper;
import ro.msg.learning.shop.mapper.SupplierMapper;
import ro.msg.learning.shop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();

    }

    public Product updateProductById(Integer id, Product updateProduct) {
        Optional<Product> productToUpdate = productRepository.findById(id);
        Product result = null;
        if (productToUpdate.isPresent()) {
            Product toUpdate = productToUpdate.get();
            toUpdate.setName(updateProduct.getName());
            toUpdate.setDescription(updateProduct.getDescription());
            toUpdate.setPrice(updateProduct.getPrice());
            toUpdate.setWeight(updateProduct.getWeight());
            toUpdate.setImageUrl(updateProduct.getImageUrl());
            toUpdate.setProductCategory(updateProduct.getProductCategory());
            toUpdate.setSupplier(updateProduct.getSupplier());
            result = productRepository.save(toUpdate);

        }
        return result;
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }


    public final Product getProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            LOGGER.error("The Product with" + id + " does not exist");
        }
        return optionalProduct.get();

    }

    public final Product createProduct(Product product) {

        return productRepository.save(product);
    }

}
