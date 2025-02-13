package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.DTO.PlaceDTO;
import bitc.fullstack503.e2teamproject.DTO.ReviewDTO;
import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import bitc.fullstack503.e2teamproject.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

  @Autowired
  private PlaceRepository placeRepository;

  @Override
  public List<ReviewEntity> reviewCheck() {
    return List.of();
  }

  @Override
  public List<PlaceEntity> placeCheck() {
    List<PlaceEntity> orderByStar = placeRepository.findAll();
    System.out.println("orderByStar");
    System.out.println("-------------");
    System.out.println(orderByStar);
    System.out.println();
    return orderByStar;
  }

  @Override
  public List<ReviewDTO> getAllReviewSortByStar() {
    List<ReviewDTO> review = placeRepository.queryFindAllReviewSortByStar();
    System.out.println("reviewStar");
    for (int i = 0; i < review.size(); i++) {
      System.out.println(review.get(i));
    }
    return review;
  }

  @Override
  public List<PlaceDTO> getAllPlaceSortByStar() {
    Pageable topThree = PageRequest.of(0,3);
    List<PlaceDTO> check = placeRepository.findTopPlacesByAverageStar(topThree);

    System.out.println("getAllPlaceSortByStar");
    for(int i=0;i<check.size();i++){
      System.out.println(check.get(i));
    }
    System.out.println();

    return placeRepository.findTopPlacesByAverageStar(topThree);
  }
}
