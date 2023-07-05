package com.nimap.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryDto {
    private Long CategoryId;
    private String CategoryName;
    private String CategoryDescription;
}
