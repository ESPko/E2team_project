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
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {

  //  리뷰 쓰기
  @Modifying
  @Transactional
  @Query(value = "insert into review (review_place_idx, review_user_idx, review_user_id, comment, star)" +
          "values (:reviewPlaceIdx, :reviewUserIdx, :reviewUserId, :reviewComment, :reviewStar)", nativeQuery = true)
  void queryWriteReview(@Param("reviewPlaceIdx") int reviewPlaceIdx,
                        @Param("reviewUserIdx") int reviewUserIdx,
                        @Param("reviewUserId") String reviewUserId,
                        @Param("reviewComment") String reviewComment,
                        @Param("reviewStar") double reviewStar);

  //  해당 장소의 리뷰 보기(심지현)
  @Modifying
  @Transactional
  @Query("select r from ReviewEntity r where r.placeReview.placeIdx= :reviewPlaceIdx")
  List<ReviewEntity> queryFindPlaceReview(@Param("reviewPlaceIdx") int reviewPlaceIdx);

  // 특정 장소의 리뷰 목록 조회 테스트
  List<ReviewEntity> findByPlaceReview_PlaceIdxOrderByStarDesc(int placeIdx);

  //  내가 작성한 리뷰
  @Query("SELECT r FROM ReviewEntity r WHERE r.userReview.user_idx = :userId")
  List<ReviewEntity> findReviewsByUserId(@Param("userId") int userId);

}

