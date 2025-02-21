package bitc.fullstack503.e2teamproject.DTO;

import bitc.fullstack503.e2teamproject.entity.PlaceImageEntity;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
public class PlaceDTO {
  private String placeName;
  private double averageStar;
  private int reviewCount;
  private List<PlaceImageEntity> placeImageEntityList;

  public PlaceDTO(String placeName, double averageStar, int reviewCount, List<PlaceImageEntity> placeImageEntityList) {
    this.placeName = placeName;
    this.averageStar = Optional.of(averageStar).orElse(0.0);
    this.reviewCount = Optional.of(reviewCount).orElse(0);
    this.placeImageEntityList = placeImageEntityList;
  }
}
