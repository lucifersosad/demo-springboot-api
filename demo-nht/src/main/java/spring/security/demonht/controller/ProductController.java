package spring.security.demonht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.security.demonht.entity.CategoryEntity;
import spring.security.demonht.entity.ProductEntity;
import spring.security.demonht.model.ProductModel;
import spring.security.demonht.model.ProductResponse;
import spring.security.demonht.repository.CategoryRepository;
import spring.security.demonht.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class ProductController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;

    @PostMapping("newmealdetail.php")
    public ResponseEntity<ProductResponse> productDetail(@RequestParam("id") String id) {
        Optional<ProductEntity> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            ProductEntity product = optional.get();
            ProductResponse response = new ProductResponse();
            ProductModel productDto = new ProductModel();
            List<ProductModel> list = new ArrayList<>();
            productDto.setId(product.getId());
            productDto.setMeal(product.getMeal());
            productDto.setArea(product.getArea());
            productDto.setCategory(product.getCategory().getName());
            productDto.setInstructions(product.getInstructions());
            productDto.setStrmealthumb(product.getStrmealthumb());
            productDto.setPrice(String.valueOf(product.getPrice()));
            list.add(productDto);
            response.setResult(list);
            response.setSuccess(true);
            response.setMessage("Thành công");
            response.setStatus(HttpStatus.OK.value());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
