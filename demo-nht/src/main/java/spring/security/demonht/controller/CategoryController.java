package spring.security.demonht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.security.demonht.entity.CategoryEntity;
import spring.security.demonht.entity.ProductEntity;
import spring.security.demonht.entity.SubjectEntity;
import spring.security.demonht.model.CategoryModel;
import spring.security.demonht.model.ProductDto;
import spring.security.demonht.model.SubjectResponse;
import spring.security.demonht.repository.CategoryRepository;
import spring.security.demonht.service.SubjectServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "categories.php", method = RequestMethod.GET)
    public ResponseEntity<List<CategoryEntity>> listAll() {
        List<CategoryEntity> list = categoryRepository.findAll();
        if (!list.isEmpty()) {
            return ResponseEntity.ok(list); // Trả về danh sách nếu không trống
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null); // Trả về mã NO_CONTENT nếu danh sách trống
        }
    }

    @PostMapping("getcategory.php")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryId(@RequestParam("idcategory") String idCate) {
        CategoryEntity category = categoryRepository.getCategoryById(idCate);
        if (category != null) {
            List<ProductDto> listProduct = new ArrayList<>();
            List<ProductEntity> list = category.getProducts();
            for (ProductEntity entity : list) {
                ProductDto dto = new ProductDto();
                dto.setId(String.valueOf(list.indexOf(entity)));
                dto.setIdcategory(idCate);
                dto.setStrMeal(entity.getMeal());
                dto.setStrMealThumb(entity.getStrmealthumb());
                dto.setIdMeal(entity.getId());
                listProduct.add(dto);
            }
            return ResponseEntity.ok(listProduct);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PostMapping("updateCategories")
    public ResponseEntity<List<CategoryEntity>> updateCategoryList(@RequestBody List<CategoryEntity> categoryList) {
        if (categoryList != null && !categoryList.isEmpty()) {
            for (CategoryEntity entity : categoryList) {
                if (!categoryRepository.existsById(entity.getId())) {
                    categoryRepository.save(entity);
                }
            }
            List<CategoryEntity> list = categoryRepository.findAll();
            return ResponseEntity.ok(list); // Trả về danh sách đã được lưu
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Trả về mã BAD_REQUEST nếu danh sách trống
        }
    }


}
