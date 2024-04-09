package spring.security.demonht.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String id;
    private String strMeal;
    private String strMealThumb;
    private String idMeal;
    private String idcategory;
}
