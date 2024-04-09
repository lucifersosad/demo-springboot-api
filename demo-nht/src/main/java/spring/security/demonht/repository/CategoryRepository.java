package spring.security.demonht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.security.demonht.entity.CategoryEntity;
import spring.security.demonht.entity.RoleEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
    @Query("select u from CategoryEntity u where u.id = :id")
    public CategoryEntity getCategoryById(@Param("id") String id);
}
