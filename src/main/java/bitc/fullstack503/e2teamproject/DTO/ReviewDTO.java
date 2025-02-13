package bitc.fullstack503.e2teamproject.DTO;

import lombok.Getter;

@Getter
public class ReviewDTO {
  private int reviewIdx;
  private String placeName; // 장소 이름
  private String comment;
  private double star;

  public ReviewDTO(int reviewIdx, String placeName, String comment, double star) {
    this.reviewIdx = reviewIdx;
    this.placeName = placeName;
    this.comment = comment;
    this.star = star;
  }
}

