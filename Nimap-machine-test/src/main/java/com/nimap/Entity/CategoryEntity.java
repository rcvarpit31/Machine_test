package com.nimap.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CategoryId;

    private String CategoryName;
    private String CategoryDescription;
    // One-to-many relationship mapping
    @OneToMany( fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "product", joinColumns = { @JoinColumn(name = "product_id") },
            inverseJoinColumns = {
      @JoinColumn(name = "category_id") })
    private List<ProductEntity> products = new ArrayList<>();



}



    //    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "ProductId",referencedColumnName = "CategoryId")
//@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.REFRESH })
//@JoinTable(name = "product", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = {
////        @JoinColumn(name = "category_id") })
//    @OneToMany(targetEntity = ProductEntity.class,cascade = CascadeType.ALL)
//    @JoinColumn(name ="cp_fk",referencedColumnName = "product_id")
//    private Set<ProductEntity> products  = new HashSet<>();
//
//// Helper method to remove a product from the category