package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.DTO.PlaceDTO;
import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Controller
@RequestMapping("/place")
public class PlaceController {

  @Autowired
  private PlaceService placeService;

  //  심지현 place 테스트용
  @RequestMapping("/jiHyunPlaceTest")
  public ModelAndView jiHyunPlaceTest() {
    ModelAndView mav = new ModelAndView("/board/jiHyunPlaceTest");
    return mav;
  }

  //  선택한 지역, 나이, 사람 수에 따라서 결과 출력
  @ResponseBody
  @GetMapping("/recommend/{selectLocation}/{selectAge}/{selectPeople}")
  public List<PlaceEntity> recommendPlace(@PathVariable("selectLocation") String selectLocation,
                                          @PathVariable("selectAge") int selectAge,
                                          @PathVariable("selectPeople") int selectPeople) {
    return placeService.recommendPlace(selectLocation, selectAge, selectPeople);
  }

  //  선택한 지역, 나이, 사람 수와 리뷰가 높은 순으로 출력
  @ResponseBody
  @RequestMapping("/recommend/starHigh/{selectLocation}/{selectAge}/{selectPeople}")
  public List<PlaceDTO> starHigh(@PathVariable("selectLocation") String selectLocation,
                       @PathVariable("selectAge") int selectAge,
                       @PathVariable("selectPeople") int selectPeople) {
    System.out.println("추천수 높은 순");
    System.out.println(placeService.findPlaceStarHigh(selectLocation,selectAge,selectPeople));
    return placeService.findPlaceStarHigh(selectLocation, selectAge, selectPeople);
  }

  //  선택한 지역, 나이, 사람 수와 리뷰가 낮은 순으로 출력
  @ResponseBody
  @RequestMapping("/recommend/starLow/{selectLocation}/{selectAge}/{selectPeople}")
  public List<PlaceDTO> starRow(@PathVariable("selectLocation") String selectLocation,
                      @PathVariable("selectAge") int selectAge,
                      @PathVariable("selectPeople") int selectPeople) {
    System.out.println("추천수 낮은 순");
    System.out.println(placeService.findPlaceStarLow(selectLocation,selectAge,selectPeople));
    return placeService.findPlaceStarLow(selectLocation, selectAge, selectPeople);
  }

  //  상위 세개 추천 항목 나오게
  @RequestMapping("/")
  public ModelAndView place() {
    ModelAndView mav = new ModelAndView("jiHyunCRUDTest");
    List<PlaceDTO> placeStarList = placeService.getAllPlaceSortByStar();
    mav.addObject("placeStarList", placeStarList);
    return mav;
  }
}
