package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ReviewService {
  //  리뷰 쓰기(실험용)
  void reviewStar(@RequestParam("reviewComment") String reviewComment,
                  @RequestParam("reviewStar") double reviewStar);

//    해당 게시글의 리뷰 테스트
    List<ReviewEntity> getReviewsByPlace(int placeIdx);

    // 리뷰 삭제 메서드 추가
    void deleteReview(int reviewIdx);

//    내가 작성한 리뷰
    List<ReviewEntity> findReviewsByUserId(int userId);


    void saveReview(int placeIdx, int userId, String comment, double star);

}

