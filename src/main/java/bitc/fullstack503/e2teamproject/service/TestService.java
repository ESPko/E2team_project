package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.entity.ReviewEntity;

import java.util.List;

public interface TestService {
  //  실험용 (삭제 가능)
  List<ReviewEntity> reviewCheck();

  List<PlaceEntity> placeCheck();
}
