package bitc.fullstack503.e2teamproject.repository;

import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
  List<ReviewEntity> findAll();
}
