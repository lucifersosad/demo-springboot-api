package spring.security.demonht.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishModel {
    private Long id;

    private String name;

    private String description;

    @JsonProperty("is_active")
    private boolean is_active;

    private String image;

    @JsonProperty("price")
    private Price priceModel;
}
