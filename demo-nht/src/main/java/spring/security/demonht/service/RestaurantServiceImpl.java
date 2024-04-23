package spring.security.demonht.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.security.demonht.entity.*;
import spring.security.demonht.model.DishModel;
import spring.security.demonht.model.DishTypeModel;
import spring.security.demonht.model.Price;
import spring.security.demonht.model.RatingModel;
import spring.security.demonht.repository.RestaurantRepository;
import spring.security.demonht.utils.Helper;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements IRestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    public List<DishTypeModel> getMenu(Long idRestaurant) {
        Restaurant restaurant = getById(idRestaurant);
        List<DishTypeModel> dishTypeModels = new ArrayList<>();
        List<DishTypeEntity> dishTypeEntityList = restaurant.getDishTypeList();
        for (DishTypeEntity dishTypeEntity : dishTypeEntityList) {
            List<Dish> dishes = dishTypeEntity.getDishes();
            List<DishModel> dishModels = new ArrayList<>();
            for (Dish dish : dishes) {
                DishModel dishModel = new DishModel();
                BeanUtils.copyProperties(dish, dishModel);
                dishModel.setPriceModel(new Price(Math.round(dish.getPrice()) + "đ", dish.getPrice()));
                dishModels.add(dishModel);
            }
            DishTypeModel dishTypeModel = new DishTypeModel();
            BeanUtils.copyProperties(dishTypeEntity, dishTypeModel);
            dishTypeModel.setDishModels(dishModels);
            dishTypeModels.add(dishTypeModel);
        }
        return dishTypeModels;
    }
    public boolean isOpen(List<RestaurantWorkingTime> workingTimes) {
        LocalDateTime currentTime = LocalDateTime.now();
        for (RestaurantWorkingTime workingTime : workingTimes) {
            if (workingTime.getWeek_day() == (currentTime.getDayOfWeek().getValue() % 7 + 1)) {
                LocalTime openingTime = workingTime.getOpen_hour().toLocalTime();
                LocalTime closingTime = workingTime.getClose_hour().toLocalTime();
                if (currentTime.toLocalTime().isAfter(openingTime) && currentTime.toLocalTime().isBefore(closingTime)) {
                    return true;
                }
            }
        }
        return false;
    }

    public RatingModel getRatingInfo(List<Rating> ratings) {
        RatingModel ratingModel = new RatingModel();

        int totalReviews = ratings.size();
        ratingModel.setTotal_review(totalReviews);

        float totalStars = 0;
        for (Rating rating : ratings) {
            totalStars += rating.getStar();
        }
        float avgStars = totalReviews > 0 ? totalStars / totalReviews : 0;
        ratingModel.setAvg(avgStars);

        ratingModel.setDisplay_total_review(Helper.formatDisplayTotalReview(totalReviews));

        return ratingModel;
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> findAllById(Iterable<Long> longs) {
        return restaurantRepository.findAllById(longs);
    }

    @Override
    public <S extends Restaurant> S save(S entity) {
        return restaurantRepository.save(entity);
    }

    @Override
    public long count() {
        return restaurantRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        restaurantRepository.deleteById(aLong);
    }

    @Override
    public void deleteAll() {
        restaurantRepository.deleteAll();
    }

    @Override
    @Deprecated
    public Restaurant getById(Long aLong) {
        return restaurantRepository.getById(aLong);
    }
}
