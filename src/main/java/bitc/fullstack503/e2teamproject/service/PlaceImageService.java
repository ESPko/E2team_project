package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.PlaceImageEntity;

import java.util.List;

public interface PlaceImageService {

  List<PlaceImageEntity> findPlaceAll();

  //  특정 장소에 대한 사진만 찾기
  List<PlaceImageEntity> findPlaceImage();
}
