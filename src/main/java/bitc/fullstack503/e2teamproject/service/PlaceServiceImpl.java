package bitc.fullstack503.e2teamproject.service;

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

  //  해당 placeIdx 의 정보 가져오기
  @Override
  public List<PlaceEntity> findPlaceDetail(int placeIdx) {
    return placeRepository.queryFindPlace(placeIdx);
  }

  //  볼링장 카테고리
  @Override
  public PlaceEntity findPlaceBalling() {
    return placeRepository.queryFindCategoryBalling();
  }

  //  클라이밍
  @Override
  public PlaceEntity findPlaceClimbing() {
    return placeRepository.queryFindCategoryClimbing();
  }

  //  코인노래방
  @Override
  public PlaceEntity findPlaceCoinSing() {
    return placeRepository.queryFindCategoryCoinSing();
  }

  //  공방
  @Override
  public PlaceEntity findPlaceGold() {
    return placeRepository.queryFindCategoryGold();
  }

  //  댄스학원
  @Override
  public PlaceEntity findPlaceDance() {
    return placeRepository.queryFindCategoryDance();
  }

  //  카트체험
  @Override
  public PlaceEntity findPlaceCart() {
    return placeRepository.queryFindCategoryCart();
  }
}
