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

  //  해당 placeIdx 의 정보 가져오기
  List<PlaceEntity> findPlaceDetail(@RequestParam("placeIdx") int placeIdx);

  //  도서관
  PlaceEntity findPlaceLibrary();

  //  동물카페
  PlaceEntity findPlaceAnimal();

  //  루지
  PlaceEntity findPlaceLoogi();

  //  멀티방
  PlaceEntity findPlaceMulti();

  //  메이드집사
  PlaceEntity findPlaceMaid();

  //  무인스튜디오
  PlaceEntity findPlaceSelfStudio();

  //  방탈출
  PlaceEntity findPlaceEscapeRoom();

  //  베이킹
  PlaceEntity findPlaceBaking();

  //  보드게임
  PlaceEntity findPlaceBoard();

  //  볼링장 카테고리
  PlaceEntity findPlaceBalling();

  //  클라이밍
  PlaceEntity findPlaceClimbing();

  //  컨벤션
  PlaceEntity findPlaceConvention();

  //  코인노래방
  PlaceEntity findPlaceCoinSing();

  //  공방
  PlaceEntity findPlaceGold();

  //  댄스학원
  PlaceEntity findPlaceDance();

  //  서바이벌
  PlaceEntity findPlaceSurvival();

  //  수상레저
//  PlaceEntity findPlaceWater();

  //  스카이다이빙
  PlaceEntity findPlaceSkyDiving();

  //  슬라임카페
  PlaceEntity findPlaceSlime();

  //  실내사격
  PlaceEntity findPlaceShooting();

  //  짚라인
  PlaceEntity findPlaceZipLine();

  //  카트체험
  PlaceEntity findPlaceCart();

  //  키자니아
  PlaceEntity findPlaceKizania();

  //테마파크
  PlaceEntity findPlaceThemePark();

  //  틱톡
  PlaceEntity findPlaceTikTok();

  //  파티룸
  PlaceEntity findPlacePartyRoom();

  //  페러세일
  PlaceEntity findPlaceParasail();

  //  홀덤펍
  PlaceEntity findPlaceHoldum();
}
