package bitc.fullstack503.e2teamproject.repository;

import bitc.fullstack503.e2teamproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
