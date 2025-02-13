package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.DTO.PlaceDTO;
import bitc.fullstack503.e2teamproject.DTO.ReviewDTO;
import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.entity.ReviewEntity;

import java.util.List;

public interface PlaceService {
//  상위 세개 추천 항목 나오게
  List<PlaceDTO> getAllPlaceSortByStar();
}
