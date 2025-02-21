package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.DTO.PlaceDTO;
import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.entity.PlaceImageEntity;
import bitc.fullstack503.e2teamproject.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/place")
public class PlaceController {

  @Autowired
  private PlaceService placeService;

  //  심지현 place 테스트용
  @RequestMapping("/jiHyunPlaceTest")
  public ModelAndView jiHyunPlaceTest() {
    return new ModelAndView("/board/jiHyunPlaceTest");
  }

  //  선택한 지역, 나이, 사람 수에 따라서 결과 출력
//  @ResponseBody
  @GetMapping("/recommend/{selectLocation}/{selectAge}/{selectPeople}")
  public ModelAndView recommendPlace(@PathVariable("selectLocation") String selectLocation,
                                     @PathVariable("selectAge") int selectAge,
                                     @PathVariable("selectPeople") int selectPeople) {
    ModelAndView mav = new ModelAndView("/board/mainDetailPage");
    List<PlaceEntity> placeDetailList = placeService.recommendPlace(selectLocation, selectAge, selectPeople);
    mav.addObject("placeDetailList", placeDetailList);

    for (PlaceEntity placeEntity : placeDetailList) {
      System.out.println(placeEntity.getPlaceIdx());
      for(PlaceImageEntity image : placeEntity.getPlaceImageEntityList()){
        System.out.println("이미지 경로 : " + image.getImagePath());
        System.out.println("이미지 이름 : " + image.getImageName());
      }
      System.out.println("------------");
    }
    return mav;
  }

  //  선택한 지역, 나이, 사람 수와 별점이 높은 순으로 출력
  @ResponseBody
  @RequestMapping("/recommend/starHigh/{selectLocation}/{selectAge}/{selectPeople}")
  public List<PlaceDTO> starHigh(@PathVariable("selectLocation") String selectLocation,
                                 @PathVariable("selectAge") int selectAge,
                                 @PathVariable("selectPeople") int selectPeople) {
    System.out.println("추천수 높은 순");
    List<PlaceDTO> showStarHigh = placeService.findPlaceStarHigh(selectLocation, selectAge, selectPeople);
    for (PlaceDTO placeDTO : showStarHigh) {
      System.out.println("이름 : " + placeDTO.getPlaceName());
      System.out.println("별점 평균 : " + placeDTO.getAverageStar());
      System.out.println("리뷰 수 : " + placeDTO.getReviewCount());
    }
    return showStarHigh;
  }

  //  선택한 지역, 나이, 사람 수와 별점이 낮은 순으로 출력
  @ResponseBody
  @RequestMapping("/recommend/starLow/{selectLocation}/{selectAge}/{selectPeople}")
  public List<PlaceDTO> starRow(@PathVariable("selectLocation") String selectLocation,
                                @PathVariable("selectAge") int selectAge,
                                @PathVariable("selectPeople") int selectPeople) {
    System.out.println("추천수 낮은 순");
    List<PlaceDTO> showStarLow = placeService.findPlaceStarLow(selectLocation, selectAge, selectPeople);
    for (PlaceDTO placeDTO : showStarLow) {
      System.out.println("이름 : " + placeDTO.getPlaceName());
      System.out.println("별점 평균 : " + placeDTO.getAverageStar());
      System.out.println("리뷰 수 : " + placeDTO.getReviewCount());
    }
    return showStarLow;
  }

  //  선택한 지역, 나이, 사람 수와 리뷰가 많은 순으로 출력
  @ResponseBody
  @RequestMapping("/recommend/reviewHigh/{selectLocation}/{selectAge}/{selectPeople}")
  public List<PlaceDTO> reviewHigh(@PathVariable("selectLocation") String selectLocation,
                                   @PathVariable("selectAge") int selectAge,
                                   @PathVariable("selectPeople") int selectPeople) {
    System.out.println("리뷰 많은 순");
    List<PlaceDTO> showReviewHigh = placeService.findPlaceReviewMany(selectLocation, selectAge, selectPeople);
    for (PlaceDTO placeDTO : showReviewHigh) {
      System.out.println("이름 : " + placeDTO.getPlaceName());
      System.out.println("별점 평균 : " + placeDTO.getAverageStar());
      System.out.println("리뷰 수 : " + placeDTO.getReviewCount());
    }
    return showReviewHigh;
  }

  //  선택한 지역, 나이, 사람 수와 리뷰가 적은 순으로 출력
  @ResponseBody
  @RequestMapping("/recommend/reviewLess/{selectLocation}/{selectAge}/{selectPeople}")
  public List<PlaceDTO> reviewLess(@PathVariable("selectLocation") String selectLocation,
                                   @PathVariable("selectAge") int selectAge,
                                   @PathVariable("selectPeople") int selectPeople) {
    System.out.println("리뷰 적은 순");
    List<PlaceDTO> showReviewLess = placeService.findPlaceReviewLess(selectLocation, selectAge, selectPeople);
    for (PlaceDTO placeDTO : showReviewLess) {
      System.out.println("이름 : " + placeDTO.getPlaceName());
      System.out.println("별점 평균 : " + placeDTO.getAverageStar());
      System.out.println("리뷰 수 : " + placeDTO.getReviewCount());
    }
    return showReviewLess;
  }

  //  상위 세개 추천 항목 나오게
//  @RequestMapping("/")
//  public ModelAndView place() {
//    ModelAndView mav = new ModelAndView("jiHyunCRUDTest");
//    List<PlaceDTO> placeStarList = placeService.getAllPlaceSortByStar();
//    mav.addObject("placeStarList", placeStarList);
//    return mav;
//  }

  //  해당 placeIdx 의 상세정보
  @RequestMapping("/detail/{placeIdx}")
  public ModelAndView placeDetail(@PathVariable("placeIdx") int placeIdx) {
    ModelAndView mav = new ModelAndView("/board/jiHyunStarTest");
    List<PlaceEntity> findPlaceDetail = placeService.findPlaceDetail(placeIdx);
    System.out.println(findPlaceDetail);
    mav.addObject("placeDetailList", findPlaceDetail);
    return mav;
  }
}
