package bitc.fullstack503.e2teamproject.DTO;

import lombok.Getter;

@Getter
public class PlaceDTO {
  private String placeName;
  private double averageStar;
  private int reviewCount;

  public PlaceDTO(String placeName, double averageStar, int reviewCount) {
    this.placeName = placeName;
    this.averageStar = averageStar;
    this.reviewCount = reviewCount;
  }
}
