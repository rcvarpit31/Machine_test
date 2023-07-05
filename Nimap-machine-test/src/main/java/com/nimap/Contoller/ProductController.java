package com.nimap.Contoller;

import com.nimap.DTO.ProductDto;
import com.nimap.Entity.ProductEntity;
import com.nimap.Repository.ProductRepository;
import com.nimap.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository ;
    @Autowired
    private ProductService  productService;
//
    // API to get all products with pagination
//    @GetMapping
//    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(defaultValue = "0") int page,
//                                                        @RequestParam(defaultValue = "10") int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Product> products = productRepository.findAll(pageable);
//        return ResponseEntity.ok(products.getContent());
//    }
@GetMapping
public Page<ProductEntity> getAllProducts(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {
    Pageable pageable = PageRequest.of(page, size);
    return productService.getAllProducts(pageable);
}

    // API to create a new product



    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
        return  productService.createProduct(product);
    }

    // API to get product by Id
    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Long id) {
       return productService.getProductById(id);
    }

    // API to update product by Id
    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id, @RequestBody ProductDto updatedProduct) {
      return  productService.updateProduct(id ,updatedProduct);
    }

    // API to delete product by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
         return productService.deleteProduct(id);
    }
}

