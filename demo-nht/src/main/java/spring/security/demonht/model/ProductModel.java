package spring.security.demonht.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private String id;
    private String meal;
    private String area;
    private String category;
    private String instructions;
    private String strmealthumb;
    private String price;
}
