package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.entity.Product;
import ro.msg.learning.shop.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> productDTOs = productService.getAllProducts();
        return  new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
        public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
        ProductDTO productToFind = productService.getProductById(id);
        return new  ResponseEntity<>(productToFind, HttpStatus.OK);
        }

        @PostMapping("/add")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody  ProductDTO productDTO){
        ProductDTO productToAdd = productService.createProduct(productDTO);
        return new ResponseEntity<>(productToAdd, HttpStatus.OK);
        }
        @PostMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProductById(@PathVariable Integer id,@RequestBody ProductDTO productToUpdate){
        ProductDTO product = productService.updateProductById(id, productToUpdate);
        return  new ResponseEntity<>(product, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Integer id){
        productService.deleteProductById(id);
    }

}
