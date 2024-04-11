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
@Table(name = "featured_category")
public class FeaturedCategory {
    @Id
    @Column(name = "featuredcateid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sellerid")
    private Seller seller;

    @OneToMany(mappedBy = "featuredCategory")
    private List<Product> products;

}
