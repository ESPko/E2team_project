package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PlaceService {
  //  지역과 연령, 나이로 찾기
  List<PlaceEntity> recommendPlace(String selectLocation, int selectAge, int selectPeople);

  //  해당 placeIdx 의 정보 가져오기
  List<PlaceEntity> findPlaceDetail(@RequestParam("placeIdx") int placeIdx);

  //  볼링장 카테고리
  PlaceEntity findPlaceBalling();

  //  클라이밍
  PlaceEntity findPlaceClimbing();

  //  코인노래방
  PlaceEntity findPlaceCoinSing();

  //  공방
  PlaceEntity findPlaceGold();

  //  댄스학원
  PlaceEntity findPlaceDance();

  //  카트체험
  PlaceEntity findPlaceCart();
}
