package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.DTO.PlaceDTO;
import bitc.fullstack503.e2teamproject.DTO.ReviewDTO;
import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import bitc.fullstack503.e2teamproject.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/place")
public class PlaceController {

  @Autowired
  private PlaceService placeService;

  //  상위 세개 추천 항목 나오게
  @RequestMapping("/")
  public ModelAndView place() {
    ModelAndView mav = new ModelAndView("/board/jiHyunTest");
    List<PlaceDTO> placeStarList = placeService.getAllPlaceSortByStar();
    mav.addObject("placeStarList", placeStarList);
    return mav;
  }
}
