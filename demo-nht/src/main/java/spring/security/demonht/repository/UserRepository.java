package spring.security.demonht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.security.demonht.entity.RoleEntity;
import spring.security.demonht.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("select u from UserEntity u where u.username = :username")
    public UserEntity getUserByUsernameParam(@Param("username") String username);

    UserEntity getUserByUsername(String username);
    Optional<UserEntity> findByUsernameOrEmail(String username, String email);
}
