package spring.security.demonht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.security.demonht.entity.DishTypeEntity;
import spring.security.demonht.entity.Restaurant;
import spring.security.demonht.model.DishTypeModel;
import spring.security.demonht.model.MenuResponse;
import spring.security.demonht.model.RestaurantModel;
import spring.security.demonht.service.RestaurantServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/dish")
public class DishController {
    @Autowired
    RestaurantServiceImpl restaurantService;
    @GetMapping("/getRestaurantMenu")
    public ResponseEntity<MenuResponse> getRestaurantDishes(@RequestParam Long idRestaurant) {
        return ResponseEntity.ok(new MenuResponse(restaurantService.getMenu(idRestaurant)));
    }
}
