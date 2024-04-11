package spring.security.demonht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.demonht.entity.Product;
import spring.security.demonht.entity.ProductEntity;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
}
