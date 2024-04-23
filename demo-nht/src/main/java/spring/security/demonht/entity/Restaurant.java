package spring.security.demonht.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @Column(name = "restaurant_id")
    private Long restaurant_id;

    private String name;

    private String address;

    private String phone;

    private String image;

    private Float latitude;

    private Float longitude;

    @OneToMany(mappedBy = "restaurant")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "restaurant")
    private List<DishTypeEntity> dishTypeList;

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantWorkingTime> availableDateTime;

}
