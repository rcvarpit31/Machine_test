package com.nimap.Service;

import com.nimap.DTO.CategoryDto;
import com.nimap.Entity.CategoryEntity;
import com.nimap.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
     @Autowired
    CategoryRepository categoryRepository;

    // API to get all categories with pagination
    public Page<CategoryEntity> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    // API to get category by Id
    public ResponseEntity<CategoryEntity> getCategoryById( Long id) {
        Optional<CategoryEntity> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

       // API to create a new category
    public  ResponseEntity<CategoryEntity> createNewCategory(CategoryEntity categoryDto){
        CategoryEntity savedCategory = categoryRepository.save(categoryDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }
    // API to update a  category
    public ResponseEntity<CategoryEntity>  updateCategory( Long id, CategoryDto updatedCategory) {
        Optional<CategoryEntity> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            CategoryEntity category = optionalCategory.get();
            category.setCategoryName(updatedCategory.getCategoryName());
            category.setCategoryDescription(updatedCategory.getCategoryDescription());
            CategoryEntity savedCategory = categoryRepository.save(category);
            return ResponseEntity.ok(savedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // API to delete category by Id
    public ResponseEntity<Void> deleteCategory( Long id) {
        categoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
