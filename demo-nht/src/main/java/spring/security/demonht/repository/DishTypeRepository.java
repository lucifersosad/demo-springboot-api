package spring.security.demonht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.security.demonht.entity.DishTypeEntity;

@Repository
public interface DishTypeRepository extends JpaRepository<DishTypeEntity, Long> {
}
