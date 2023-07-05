package com.nimap.DTO;

import lombok.*;

import javax.persistence.Entity;
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long ProductId;
    private String ProductName;
    private float ProductPrice ;
}
