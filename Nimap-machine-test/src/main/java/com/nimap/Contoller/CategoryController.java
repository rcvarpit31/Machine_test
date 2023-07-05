package com.nimap.Contoller;

import com.nimap.DTO.CategoryDto;
import com.nimap.Entity.CategoryEntity;
import com.nimap.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // API to get all categories with pagination
    @GetMapping
    public Page<CategoryEntity> getAllCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return categoryService.getAllCategories(pageable);
    }


    // API to create a new category
    @PostMapping
    public ResponseEntity<CategoryEntity> createCategory(@RequestBody CategoryEntity category) {
        return categoryService.createNewCategory(category);
    }

    // API to get category by Id

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    // API to update category by Id
    @PutMapping("/{id}")
    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Long id, @RequestBody CategoryDto updatedCategory) {
        return categoryService.updateCategory(id, updatedCategory);

    }

    // API to delete category by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {

        return categoryService.deleteCategory(id);
    }
}
