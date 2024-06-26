package spring.security.demonht.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @Column(name = "cateid")
    private String id;
    private String name;
    private String images;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;
}
