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

  //  도서관
  @Override
  public PlaceEntity findPlaceLibrary() {
    return placeRepository.queryFindCategoryLibrary();
  }

  //  동물카페
  @Override
  public PlaceEntity findPlaceAnimal() {
    return placeRepository.queryFindCategoryAnimal();
  }

  //  루지
  @Override
  public PlaceEntity findPlaceLoogi() {
    return placeRepository.queryFindCategoryLoogi();
  }

  //  멀티방
  @Override
  public PlaceEntity findPlaceMulti() {
    return placeRepository.queryFindCategoryMulti();
  }

  //  메이드집사
  @Override
  public PlaceEntity findPlaceMaid() {
    return placeRepository.queryFindCategoryMaid();
  }

  //  무인스튜디오
  @Override
  public PlaceEntity findPlaceSelfStudio() {
    return placeRepository.queryFindCategorySelfStudio();
  }

  //  방탈출
  @Override
  public PlaceEntity findPlaceEscapeRoom() {
    return placeRepository.queryFindCategoryEscapeRoom();
  }

  //  베이킹
  @Override
  public PlaceEntity findPlaceBaking() {
    return placeRepository.queryFindCategoryBaking();
  }

  //  보드게임
  @Override
  public PlaceEntity findPlaceBoard() {
    return placeRepository.queryFindCategoryBoard();
  }

  //  보드게임 리스트
  @Override
  public List<PlaceEntity> findPlaceBoardList() {
    return placeRepository.queryFindBoardList();
  }

  //  볼링장 카테고리 하나
  @Override
  public PlaceEntity findPlaceBalling() {
    return placeRepository.queryFindCategoryBalling();
  }

  //  볼링장 전부
  @Override
  public List<PlaceEntity> findPlaceBallingList() {
    return placeRepository.queryFindBallingList();
  }

  //  서바이벌
  @Override
  public PlaceEntity findPlaceSurvival() {
    return placeRepository.queryFindCategorySurvival();
  }

  //  서핑
  @Override
  public PlaceEntity findPlaceSurfing() {
    return placeRepository.queryFindCategorySurfing();
  }

  //  스카이다이빙
  @Override
  public PlaceEntity findPlaceSkyDiving() {
    return placeRepository.queryFindCategorySkyDiving();
  }

  //  슬라임카페
  @Override
  public PlaceEntity findPlaceSlime() {
    return placeRepository.queryFindCategorySlime();
  }

  //  실내사격
  @Override
  public PlaceEntity findPlaceShooting() {
    return placeRepository.queryFindCategoryShooting();
  }

  //  짚라인
  @Override
  public PlaceEntity findPlaceZipLine() {
    return placeRepository.queryFindCategoryZipLine();
  }

  //  카트체험
  @Override
  public PlaceEntity findPlaceCart() {
    return placeRepository.queryFindCategoryCart();
  }

  //  컨벤션
  @Override
  public PlaceEntity findPlaceConvention() {
    return placeRepository.queryFindCategoryConvention();
  }

  //  코인노래방
  @Override
  public PlaceEntity findPlaceCoinSing() {
    return placeRepository.queryFindCategoryCoinSing();
  }

  //  클라이밍
  @Override
  public PlaceEntity findPlaceClimbing() {
    return placeRepository.queryFindCategoryClimbing();
  }

  //  클라이밍 전부
  @Override
  public List<PlaceEntity> findPlaceClimbingList() {
    return placeRepository.queryFindClimbingList();
  }

  //  키자니아
  @Override
  public PlaceEntity findPlaceKizania() {
    return placeRepository.queryFindCategoryKizania();
  }

  //  키즈카페
  @Override
  public PlaceEntity findPlaceKidsCafe() {
    return placeRepository.queryFindCategoryKidsCafe();
  }

  //테마파크
  @Override
  public PlaceEntity findPlaceThemePark() {
    return placeRepository.queryFindCategoryThemePark();
  }

  //  틱톡
  @Override
  public PlaceEntity findPlaceTikTok() {
    return placeRepository.queryFindCategoryTikTok();
  }

  //  파티룸
  @Override
  public PlaceEntity findPlacePartyRoom() {
    return placeRepository.queryFindCategoryPartyRoom();
  }

  //  페러세일
  @Override
  public PlaceEntity findPlaceParasail() {
    return placeRepository.queryFindCategoryParasail();
  }

  //  홀덤펍
  @Override
  public PlaceEntity findPlaceHoldum() {
    return placeRepository.queryFindCategoryHoldum();
  }
}
