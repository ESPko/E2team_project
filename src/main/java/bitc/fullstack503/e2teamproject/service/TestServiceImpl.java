package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import bitc.fullstack503.e2teamproject.repository.PlaceRepository;
import bitc.fullstack503.e2teamproject.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

  @Autowired
  private ReviewRepository reviewRepository;

  @Autowired
  private PlaceRepository placeRepository;

  //  실험용 (삭제 가능)
  @Override
  public List<ReviewEntity> reviewCheck(){
//    List<ReviewEntity> orderByStar = reviewRepository.findAll();
//    List<ReviewEntity> asdf = reviewRepository.findReviewsByPlaceSortedByStar();
//    System.out.println("orderByStar");
//    System.out.println(orderByStar);
//    System.out.println();
    System.out.println("asdf");
//    System.out.println(asdf);
    System.out.println();
    return null;
  }

  @Override
  public List<PlaceEntity> placeCheck(){
//    List<PlaceEntity> orderByStar = placeRepository.queryFindAll();
//    System.out.println("orderByStar");
//    System.out.println(orderByStar);
//    System.out.println();
//    return orderByStar;
    return null;
  }
}
