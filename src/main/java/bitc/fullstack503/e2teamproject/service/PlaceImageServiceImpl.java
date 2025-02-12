package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.repository.PlaceImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceImageServiceImpl implements PlaceImageService {

  @Autowired
  private PlaceImageRepository placeImageRepository;
}
