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
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rating_id;
    private String title;
    @Column(length = 1000)
    private String content;
    private int star;

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;
}
