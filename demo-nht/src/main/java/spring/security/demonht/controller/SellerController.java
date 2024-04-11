package spring.security.demonht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.security.demonht.entity.Seller;
import spring.security.demonht.model.Response;
import spring.security.demonht.repository.SellerRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class SellerController {
    @Autowired
    SellerRepository sellerRepository;

    @PostMapping("getSeller")
    public ResponseEntity<List<Seller>> productDetail(@RequestParam("idSeller") Long id) {
        List<Seller> list = sellerRepository.findAll();
        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
