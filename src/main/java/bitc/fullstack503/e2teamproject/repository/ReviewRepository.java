package bitc.fullstack503.e2teamproject.repository;

import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {

  @Modifying
  @Transactional
  @Query(value = "insert into review (review_place_idx, review_user_idx, comment, star)" +
          "values (1, 2, :reviewComment, :reviewStar)", nativeQuery = true)
  void queryWriteReview(@Param("reviewComment") String reviewComment, @Param("reviewStar") double reviewStar);

}
