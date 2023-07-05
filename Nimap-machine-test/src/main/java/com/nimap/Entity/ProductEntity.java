package com.nimap.Entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProductId;
    private String ProductName;
    private float ProductPrice ;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;


}







// Other product properties

//    @Transient
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private CategoryEntity category;

//    private List<Rating> ratings  = new ArrayList<>();
//@Transient
//private List<Category> categories = new ArrayList<>();
// Constructors, getters, and setters


//    public void setCategory(Category category) {
//        this.category = category;
//    }