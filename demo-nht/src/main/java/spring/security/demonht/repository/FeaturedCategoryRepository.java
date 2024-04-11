package spring.security.demonht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.demonht.entity.FeaturedCategory;

@Repository
public interface FeaturedCategoryRepository extends JpaRepository<FeaturedCategory, Long> {
}
