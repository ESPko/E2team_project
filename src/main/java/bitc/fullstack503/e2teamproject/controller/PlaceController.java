package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.DTO.PlaceDTO;
import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    return mav;
  }

  //  선택한 지역, 나이, 사람 수와 별점이 높은 순으로 출력
  @ResponseBody
  @RequestMapping("/recommend/starHigh/{selectLocation}/{selectAge}/{selectPeople}")
  public Model starHigh(@PathVariable("selectLocation") String selectLocation,
                        @PathVariable("selectAge") int selectAge,
                        @PathVariable("selectPeople") int selectPeople,
                        Model model) {
    System.out.println("추천수 높은 순");
    List<PlaceDTO> placeDetailList = placeService.findPlaceStarHigh(selectLocation, selectAge, selectPeople);
    Model starHighModel = model.addAttribute("placeDetailList", placeDetailList);
    return starHighModel;
  }

  //  선택한 지역, 나이, 사람 수와 별점이 낮은 순으로 출력
  @ResponseBody
  @RequestMapping("/recommend/starLow/{selectLocation}/{selectAge}/{selectPeople}")
  public List<PlaceDTO> starRow(@PathVariable("selectLocation") String selectLocation,
                                @PathVariable("selectAge") int selectAge,
                                @PathVariable("selectPeople") int selectPeople) {
    System.out.println("추천수 낮은 순");
    List<PlaceDTO> showStarLow = placeService.findPlaceStarLow(selectLocation, selectAge, selectPeople);
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
