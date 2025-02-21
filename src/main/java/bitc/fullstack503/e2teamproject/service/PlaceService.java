package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.DTO.PlaceDTO;
import bitc.fullstack503.e2teamproject.DTO.ReviewDTO;
import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PlaceService {
  //  지역과 연령, 나이로 찾기
  List<PlaceEntity> recommendPlace(String selectLocation, int selectAge, int selectPeople);

  //  지역 연령 나이로 찾되 추천수가 높은 순으로 정렬
  List<PlaceDTO> findPlaceStarHigh(String selectLocation, int selectAge, int selectPeople);

  //  지역 연령 나이로 찾되 추천수가 낮은 순으로
  List<PlaceDTO> findPlaceStarLow(String selectLocation, int selectAge, int selectPeople);

  //  지역 연령 나이로 찾되 리뷰가 많은 순으로 결정
  List<PlaceDTO> findPlaceReviewMany(String selectLocation, int selectAge, int selectPeople);

  //  지역 연령 나이로 찾되 리뷰가 적은 순으로 결정
  List<PlaceDTO> findPlaceReviewLess(String selectLocation, int selectAge, int selectPeople);

  //  해당 placeIdx 의 정보 가져오기
  List<PlaceEntity> findPlaceDetail(@RequestParam("placeIdx") int placeIdx);

  //  상위 세개 추천 항목 나오게
//  List<PlaceDTO> getAllPlaceSortByStar();


}
