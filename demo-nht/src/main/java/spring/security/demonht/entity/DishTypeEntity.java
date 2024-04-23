package spring.security.demonht.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.security.demonht.model.DishModel;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dish_type")
public class DishTypeEntity {
    @Id
    @Column(name = "dish_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dish_type_id;

    private String dish_type_name;

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "dishType")
    private List<Dish> dishes;
}
