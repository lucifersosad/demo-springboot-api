package spring.security.demonht.service;

import spring.security.demonht.entity.Restaurant;

import java.util.List;

public interface IRestaurantService {
    List<Restaurant> findAll();

    List<Restaurant> findAllById(Iterable<Long> longs);

    <S extends Restaurant> S save(S entity);

    long count();

    void deleteById(Long aLong);

    void deleteAll();

    @Deprecated
    Restaurant getById(Long aLong);
}
