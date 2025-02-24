package bitc.fullstack503.e2teamproject.DTO;

import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewDTO {
  private int reviewIdx;
  private String reviewUserId;
  private String reviewUserName;
  private String comment;
  private double star;
  private int reviewUserIdx;
  private int reviewPlaceIdx;

  public static ReviewDTO fromEntity(ReviewEntity review) {
    return new ReviewDTO(
            review.getReviewIdx(),
            review.getReviewUserId(),
            review.getReviewUserName(),
            review.getComment(),
            review.getStar(),
            review.getUserReview().getUser_idx(),
            review.getPlaceReview().getPlaceIdx()
    );
  }
}


