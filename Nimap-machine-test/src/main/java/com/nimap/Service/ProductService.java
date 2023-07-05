package com.nimap.Service;

import com.nimap.DTO.ProductDto;
import com.nimap.Entity.ProductEntity;
import com.nimap.Repository.CategoryRepository;
import com.nimap.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository ;
    public Page<ProductEntity> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    // API to create a new product
    public ResponseEntity<ProductEntity> createProduct( ProductEntity product) {
        ProductEntity savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    // API to get product by Id
    public ResponseEntity<ProductEntity> getProductById( Long id) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        return optionalProduct.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // API to update product by Id
    public ResponseEntity<ProductEntity> updateProduct(Long id, ProductDto updatedProduct) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity product = optionalProduct.get();
            product.setProductName(updatedProduct.getProductName());
            product.setProductPrice(updatedProduct.getProductPrice());
            // Set other properties to update if needed
            ProductEntity savedProduct = productRepository.save(product);
            return ResponseEntity.ok(savedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // API to delete product by Id

    public ResponseEntity<Void> deleteProduct(Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
