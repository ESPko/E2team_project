// UserRepository.java
package bitc.fullstack503.e2teamproject.repository;

import bitc.fullstack503.e2teamproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findById(String id);
    Optional<UserEntity> findByIdAndPassword(String id, String password);
}
