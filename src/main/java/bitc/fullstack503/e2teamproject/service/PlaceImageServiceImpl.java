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
  public List<PlaceImageEntity> findPlaceAll(){
    List<PlaceImageEntity> findImage = placeImageRepository.findAll();
    return findImage;
  }

}
