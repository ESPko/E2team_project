package bitc.fullstack503.e2teamproject.repository;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
}
