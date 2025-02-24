package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.ReplyEntity;
import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ReviewService {
  //  리뷰 쓰기(심지현)
  void reviewStar(@RequestParam("reviewPlaceIdx") int reviewPlaceIdx,
                  @RequestParam("reviewUserIdx") int reviewUserIdx,
                  @RequestParam("reviewUserId") String reviewUserId,
                  @RequestParam("reviewUserName") String reviewUserName,
                  @RequestParam("reviewComment") String reviewComment,
                  @RequestParam("reviewStar") double reviewStar);

  //    해당 게시글의 리뷰 테스트
  List<ReviewEntity> getReviewsByPlace(int placeIdx);

  // 리뷰 삭제 메서드 추가
  void deleteReview(int reviewIdx);

  //    내가 작성한 리뷰
  Page<ReviewEntity> findReviewsByUserId(int userId, Pageable pageable);

  //  리뷰 쓰기(그 남성분)
  void saveReview(int placeIdx, int userId, String comment, double star);

  //  리뷰 보기(심지현)
  List<ReviewEntity> readReview(int reviewPlaceIdx);

  //  별점 평균
  double averageStar(@RequestParam("placeIdx") int placeIdx);

  //  리뷰 갯수
  int countReview(int placeIdx);
}

