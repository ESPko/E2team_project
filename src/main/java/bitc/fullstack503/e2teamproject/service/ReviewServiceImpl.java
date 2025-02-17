//package bitc.fullstack503.e2teamproject.service;
//
//import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
//import bitc.fullstack503.e2teamproject.repository.ReviewRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ReviewServiceImpl implements ReviewService {
//
//  @Autowired
//  private ReviewRepository reviewRepository;
//}

package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import bitc.fullstack503.e2teamproject.repository.ReviewRepository;
import bitc.fullstack503.e2teamproject.service.ReviewService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
  private final ReviewRepository reviewRepository;


//  해당 게시물에서 작성한 리뷰 테스트
  @Override
  public List<ReviewEntity> getReviewsByPlace(int placeIdx) {

    return reviewRepository.findByPlaceReview_PlaceIdxOrderByStarDesc(placeIdx);


  }

//   리뷰 삭제 테스트
  @Override
  @Transactional
  public void deleteReview(int reviewIdx) {
    reviewRepository.deleteById(reviewIdx);
  }

// 내가 작성한 리뷰
  @Override
  public List<ReviewEntity> findReviewsByUserId(int userId) {

    return reviewRepository.findReviewsByUserId(userId);
  }

}

