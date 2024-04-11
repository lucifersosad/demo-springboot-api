package spring.security.demonht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.demonht.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
}