package bitc.fullstack503.e2teamproject.DTO;

import lombok.Getter;

@Getter
public class PlaceDTO {
  private String placeName;
  private double averageStar;

  public PlaceDTO(String placeName, double averageStar) {
    this.placeName = placeName;
    this.averageStar = averageStar;
  }
}
