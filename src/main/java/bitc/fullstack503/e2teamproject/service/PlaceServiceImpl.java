package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.DTO.PlaceDTO;
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
}
