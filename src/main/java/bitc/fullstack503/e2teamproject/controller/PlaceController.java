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
    return mav;
  }

  //  별점 높은순
  @RequestMapping("/recommend/{selectLocation}/{selectAge}/{selectPeople}/starHigh")
  public ModelAndView recommendStarHigh(@PathVariable("selectLocation") String selectLocation,
                                        @PathVariable("selectAge") int selectAge,
                                        @PathVariable("selectPeople") int selectPeople) {
    ModelAndView mav = new ModelAndView("/place/starHigh");
    List<PlaceEntity> placeDetailList = placeService.starHigh(selectLocation, selectAge, selectPeople);

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

  //  별점 낮은순
  @RequestMapping("/recommend/{selectLocation}/{selectAge}/{selectPeople}/starLow")
  public ModelAndView recommendStarLow(@PathVariable("selectLocation") String selectLocation,
                                        @PathVariable("selectAge") int selectAge,
                                        @PathVariable("selectPeople") int selectPeople) {
    ModelAndView mav = new ModelAndView("/place/starLow");
    List<PlaceEntity> placeDetailList = placeService.starLow(selectLocation, selectAge, selectPeople);

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

  //  리뷰 많은 순
  @RequestMapping("/recommend/{selectLocation}/{selectAge}/{selectPeople}/reviewHigh")
  public ModelAndView recommendReviewHigh(@PathVariable("selectLocation") String selectLocation,
                                        @PathVariable("selectAge") int selectAge,
                                        @PathVariable("selectPeople") int selectPeople) {
    ModelAndView mav = new ModelAndView("/place/reviewHigh");
    List<PlaceEntity> placeDetailList = placeService.reviewHigh(selectLocation, selectAge, selectPeople);

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

  //  리뷰 적은 순
  @RequestMapping("/recommend/{selectLocation}/{selectAge}/{selectPeople}/reviewLow")
  public ModelAndView recommendReviewLow(@PathVariable("selectLocation") String selectLocation,
                                        @PathVariable("selectAge") int selectAge,
                                        @PathVariable("selectPeople") int selectPeople) {
    ModelAndView mav = new ModelAndView("/place/reviewLow");
    List<PlaceEntity> placeDetailList = placeService.reviewLow(selectLocation, selectAge, selectPeople);

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
}
