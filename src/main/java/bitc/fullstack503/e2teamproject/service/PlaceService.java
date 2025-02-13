package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.DTO.PlaceDTO;
import bitc.fullstack503.e2teamproject.DTO.ReviewDTO;
import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.entity.ReviewEntity;

import java.util.List;

public interface PlaceService {
  //  실험용 (삭제 가능)
  List<ReviewEntity> reviewCheck();

  List<PlaceEntity> placeCheck();

  List<ReviewDTO> getAllReviewSortByStar();

  List<PlaceDTO> getAllPlaceSortByStar();
}
