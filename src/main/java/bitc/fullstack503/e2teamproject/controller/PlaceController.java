package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.service.PlaceService;
import bitc.fullstack503.e2teamproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/place")
public class PlaceController {

  @Autowired
  private PlaceService placeService;

  @Autowired
  private ReviewService reviewService;

  //  선택한 지역, 나이, 사람 수에 따라서 결과 출력
  @GetMapping("/recommend/{selectLocation}/{selectAge}/{selectPeople}")
  public ModelAndView recommendPlace(@PathVariable("selectLocation") String selectLocation,
                                     @PathVariable("selectAge") int selectAge,
                                     @PathVariable("selectPeople") int selectPeople) {
    ModelAndView mav = new ModelAndView("/place/mainDetailPage");
    List<PlaceEntity> placeDetailList = placeService.recommendPlace(selectLocation, selectAge, selectPeople);

    // 각 장소의 별점 평균과 리뷰 개수를 조회하여 추가
    for (PlaceEntity place : placeDetailList) {
      int placeIdx = place.getPlaceIdx();
      double averageStar = reviewService.averageStar(placeIdx);
      int reviewCount = reviewService.countReview(placeIdx);

      // PlaceEntity에 별점과 리뷰 개수를 저장할 필드가 있다면 set
      place.setAverageStar(averageStar);
      place.setReviewCount(reviewCount);
    }

    mav.addObject("placeDetailList", placeDetailList);
    return mav;
  }

  //  해당 placeIdx 의 상세정보
  @RequestMapping("/detail/{placeIdx}")
  public ModelAndView placeDetail(@PathVariable("placeIdx") int placeIdx) {
    ModelAndView mav = new ModelAndView("/place/DetailReviewPage");
    List<PlaceEntity> findPlaceDetail = placeService.findPlaceDetail(placeIdx);
    mav.addObject("placeDetailList", findPlaceDetail);

    //    별점 평균 확인용
    double findAverageStar = reviewService.averageStar(placeIdx);
    System.out.println("averageStar : " + findAverageStar);

    //    리뷰 갯수 확인용
    int reviewCount = reviewService.countReview(placeIdx);
    System.out.println("reviewCount : " + reviewCount);
    return mav;
  }

//  리뷰 확인용
}
