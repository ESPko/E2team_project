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

  //  해당 placeIdx 의 상세정보
  @RequestMapping("/detail/{placeIdx}")
  public ModelAndView placeDetail(@PathVariable("placeIdx") int placeIdx) {
    ModelAndView mav = new ModelAndView("/board/DetailReviewPage");
    List<PlaceEntity> findPlaceDetail = placeService.findPlaceDetail(placeIdx);
    System.out.println(findPlaceDetail);
    mav.addObject("placeDetailList", findPlaceDetail);
    return mav;
  }
}
