package spring.security.demonht.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.security.demonht.entity.Restaurant;
import spring.security.demonht.model.DeliveryReponse;
import spring.security.demonht.model.Position;
import spring.security.demonht.model.RestaurantModel;
import spring.security.demonht.repository.RestaurantRepository;
import spring.security.demonht.service.RestaurantServiceImpl;
import spring.security.demonht.utils.Converter;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    @Autowired
    RestaurantServiceImpl restaurantService;
    @GetMapping("/getDetail")
    public ResponseEntity<DeliveryReponse> getDeliveryDetail(@RequestParam Long idRestaurant) {
        Restaurant restaurant = restaurantService.getById(idRestaurant);
        RestaurantModel restaurantModel = new RestaurantModel();
        BeanUtils.copyProperties(restaurant, restaurantModel);
        restaurantModel.setAvailable_times(Converter.convertToDateTimeList(restaurant.getAvailableDateTime()));
        restaurantModel.setRating(restaurantService.getRatingInfo(restaurant.getRatings()));
        restaurantModel.setPosition(new Position(restaurant.getLatitude(), restaurant.getLongitude()));
        restaurantModel.setOpen(restaurantService.isOpen(restaurant.getAvailableDateTime()));
        return ResponseEntity.ok(new DeliveryReponse(restaurantModel));
    }
}
