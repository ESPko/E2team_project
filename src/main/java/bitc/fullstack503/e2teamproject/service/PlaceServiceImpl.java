package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.DTO.PlaceDTO;
import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

  @Autowired
  private PlaceRepository placeRepository;

  //  지역과 연령, 나이로 찾기
  @Override
  public List<PlaceEntity> recommendPlace(String selectLocation, int selectAge, int selectPeople) {
    return placeRepository.findByLocation(selectLocation, selectAge, selectPeople);
  }

  //  지역 연령 나이로 찾되 추천수가 높은 순으로 정렬
  @Override
  public List<PlaceDTO> findPlaceStarHigh(String selectLocation, int selectAge, int selectPeople) {
    return placeRepository.findPlaceStarHigh(selectLocation, selectAge, selectPeople);
  }

  //  지역 연령 나이로 찾되 추천수가 낮은 순으로 결정
  @Override
  public List<PlaceDTO> findPlaceStarLow(String selectLocation, int selectAge, int selectPeople) {
    return placeRepository.findPlaceStarLow(selectLocation, selectAge, selectPeople);
  }

//  지역 연령 나이로 찾되 리뷰가 많은 순으로 결정
@Override
public List<PlaceDTO> findPlaceReviewMany(String selectLocation, int selectAge, int selectPeople){
    return placeRepository.findPlaceReviewMany(selectLocation, selectAge, selectPeople);
  }

//  지역 연령 나이로 찾되 리뷰가 적은 순으로 결정
@Override
public List<PlaceDTO> findPlaceReviewLess(String selectLocation, int selectAge, int selectPeople){
    return placeRepository.findPlaceReviewLess(selectLocation, selectAge, selectPeople);
  }

  //  상위 세개 추천 항목 나오게
//  @Override
//  public List<PlaceDTO> getAllPlaceSortByStar() {
//    Pageable topThree = PageRequest.of(0, 3);
//    List<PlaceDTO> check = placeRepository.findTopPlacesByAverageStar(topThree);
//
//    System.out.println("getAllPlaceSortByStar");
//    for (int i = 0; i < check.size(); i++) {
//      System.out.println(check.get(i));
//    }
//    System.out.println();
//
//    return placeRepository.findTopPlacesByAverageStar(topThree);
//  }

  //  해당 placeIdx 의 정보 가져오기
  @Override
  public List<PlaceEntity> findPlaceDetail(int placeIdx){
    return placeRepository.queryFindPlace(placeIdx);
  }
}
