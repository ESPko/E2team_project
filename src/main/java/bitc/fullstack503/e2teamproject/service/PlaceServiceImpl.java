package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements PlaceService {

  @Autowired
  private PlaceRepository placeRepository;
}
