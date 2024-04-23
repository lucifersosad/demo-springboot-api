package spring.security.demonht.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.security.demonht.entity.DishTypeEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuResponse {
    private List<DishTypeModel> menu_infos;
}
