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

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public ProductDTO updateProductById(Integer id, ProductDTO updateProduct) {
        Optional<Product> productToUpdate = productRepository.findById(id);
        ProductDTO result = null;
        if (productToUpdate.isPresent()) {

            Product updated = productToUpdate.get();

            updated.setName(updateProduct.getName());
            updated.setDescription(updateProduct.getDescription());
            updated.setPrice(updateProduct.getPrice());
            updated.setWeight(updateProduct.getWeight());
            updated.setImageUrl(updateProduct.getImageUrl());
            updated.setProductCategory(CategoryMapper.fromDtoToEntity(updateProduct.getProductCategory()));
            updated.setSupplier(SupplierMapper.fromDtoToEntity(updateProduct.getSupplier()));
            Product last = productRepository.save(updated);
            result = ProductMapper.fromEntityToDto(last);
        }
        return result;
    }
    public void deleteProductById(Integer id) {
       productRepository.deleteById(id);
    }


    public final ProductDTO getProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) {
            LOGGER.error("The Product with" + id + " does not exist");
        }
        return ProductMapper.fromEntityToDto(optionalProduct.get());

    }

    public final ProductDTO createProduct(ProductDTO productDTO) {
        Product product = ProductMapper.fromDtoToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.fromEntityToDto(savedProduct);
    }

}
