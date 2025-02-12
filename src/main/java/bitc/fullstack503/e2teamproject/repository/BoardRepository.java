package bitc.fullstack503.e2teamproject.repository;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    @Query("SELECT b FROM BoardEntity b ORDER BY b.board_idx DESC")
    List<BoardEntity> findAllByOrderByBoard_idxDesc();

}
