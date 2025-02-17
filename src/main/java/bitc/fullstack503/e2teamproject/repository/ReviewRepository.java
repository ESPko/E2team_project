//package bitc.fullstack503.e2teamproject.repository;
//
//import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
//  List<ReviewEntity> findAll();
//}

package bitc.fullstack503.e2teamproject.repository;

import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
  // 특정 장소의 리뷰 목록 조회 테스트
  List<ReviewEntity> findByPlaceReview_PlaceIdxOrderByStarDesc(int placeIdx);

//  내가 작성한 리뷰
  @Query("SELECT r FROM ReviewEntity r WHERE r.userReview.user_idx = :userId")
  List<ReviewEntity> findReviewsByUserId(@Param("userId") int userId);
}

