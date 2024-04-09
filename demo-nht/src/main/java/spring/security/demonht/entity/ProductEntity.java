package spring.security.demonht.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @Column(name = "proid")
    private String id;
    private String meal;
    private String area;
    @Column(length = 2000)
    private String instructions;
    @Column(length = 1000)
    private String strmealthumb;
    @Column(nullable = true)
    private Float price;

    @ManyToOne
    @JoinColumn(name="cateid")
    private CategoryEntity category;

}
