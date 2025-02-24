package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import bitc.fullstack503.e2teamproject.entity.UserEntity;
import bitc.fullstack503.e2teamproject.repository.PlaceRepository;
import bitc.fullstack503.e2teamproject.repository.ReviewRepository;
import bitc.fullstack503.e2teamproject.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
  private final ReviewRepository reviewRepository;
  private final PlaceRepository placeRepository;
  private final UserRepository userRepository;


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
  public Page<ReviewEntity> findReviewsByUserId(int userId, Pageable pageable) {
    return reviewRepository.findReviewsByUserId(userId, pageable);
  }

  //  리뷰 쓰기
  @Override
  public void reviewStar(int reviewPlaceIdx, int reviewUserIdx, String reviewUserId, String reviewUserName, String reviewComment, double reviewStar) {
    reviewRepository.queryWriteReview(reviewPlaceIdx, reviewUserIdx, reviewUserId, reviewUserName, reviewComment, reviewStar);
  }

  @Transactional
  @Override
  public void saveReview(int placeIdx, int userId, String comment, double star) {
    UserEntity user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
    PlaceEntity place = placeRepository.findById(placeIdx)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 장소입니다."));

    ReviewEntity review = ReviewEntity.builder()
            .userReview(user)
            .placeReview(place)
            .comment(comment)
            .star(star)
            .writeDate(LocalDateTime.now())
            .build();

    reviewRepository.save(review);
  }

  //  리뷰 보기(심지현)
  @Override
  public List<ReviewEntity> readReview(int reviewPlaceIdx) {
    return reviewRepository.queryFindPlaceReview(reviewPlaceIdx);
  }

  //  별점 평균
  @Override
  public double averageStar(int placeIdx) {
    return reviewRepository.queryAverageStar(placeIdx);
  }

  //  리뷰 갯수
  @Override
  public int countReview(int placeIdx) {
    return reviewRepository.queryCountReview(placeIdx);
  }
}

