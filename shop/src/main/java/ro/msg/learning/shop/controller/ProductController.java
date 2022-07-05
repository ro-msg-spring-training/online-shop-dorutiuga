package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.entity.Product;
import ro.msg.learning.shop.mapper.ProductMapper;
import ro.msg.learning.shop.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> productDTOS = products.stream().map(ProductMapper::fromEntityToDto).collect(Collectors.toList());
        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        ProductDTO productToFind = ProductMapper.fromEntityToDto(product);
        return new ResponseEntity<>(productToFind, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        Product product = productService.createProduct(ProductMapper.fromDtoToEntity(productDTO));
        ProductDTO productToAdd = ProductMapper.fromEntityToDto(product);
        return new ResponseEntity<>(productToAdd, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProductById(@PathVariable Integer id, @RequestBody ProductDTO productToUpdate) {
        Product product = productService.updateProductById(id, ProductMapper.fromDtoToEntity(productToUpdate));
        ProductDTO productDTO = ProductMapper.fromEntityToDto(product);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }

}
