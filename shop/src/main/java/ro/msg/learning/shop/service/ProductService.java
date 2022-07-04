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

            Product toUpdate = productToUpdate.get();

            toUpdate.setName(updateProduct.getName());
            toUpdate.setDescription(updateProduct.getDescription());
            toUpdate.setPrice(updateProduct.getPrice());
            toUpdate.setWeight(updateProduct.getWeight());
            toUpdate.setImageUrl(updateProduct.getImageUrl());
            toUpdate.setProductCategory(CategoryMapper.fromDtoToEntity(updateProduct.getProductCategory()));
            toUpdate.setSupplier(SupplierMapper.fromDtoToEntity(updateProduct.getSupplier()));

            Product updated = productRepository.save(toUpdate);
            result = ProductMapper.fromEntityToDto(updated);
        }
        return result;
    }
    public void deleteProductById(Integer id) {
       productRepository.deleteById(id);
    }


    public final ProductDTO getProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
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
