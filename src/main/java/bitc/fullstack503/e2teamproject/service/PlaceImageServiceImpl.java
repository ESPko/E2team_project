package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.PlaceImageEntity;
import bitc.fullstack503.e2teamproject.repository.PlaceImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceImageServiceImpl implements PlaceImageService {
  @Autowired
  private PlaceImageRepository placeImageRepository;

  @Override
  public List<PlaceImageEntity> findPlaceAll() {
    return placeImageRepository.findAll();
  }

  //  특정 장소에 대한 사진만 찾기
  @Override
  public List<PlaceImageEntity> findPlaceImage() {
    return placeImageRepository.queryFindImage();
  }

}
