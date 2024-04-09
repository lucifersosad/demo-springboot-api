package spring.security.demonht.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.security.demonht.entity.ProductEntity;
import spring.security.demonht.entity.SubjectEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse extends Response {
    private List<ProductModel> result;
}
