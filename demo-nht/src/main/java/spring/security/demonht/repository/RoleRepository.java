package spring.security.demonht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.security.demonht.entity.RoleEntity;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    @Query("select u from RoleEntity u where u.name = :name")
    public RoleEntity getUserByName(@Param("name") String name);
    Optional<RoleEntity> findByName(String name);
}
