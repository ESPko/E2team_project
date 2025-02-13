package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import bitc.fullstack503.e2teamproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
  @Autowired
  private TestService testService;

  //  실험용 (삭제 가능)
  @RequestMapping("/")
  public ModelAndView place() {
    ModelAndView mav = new ModelAndView("/board/jiHyunTest");
    List<ReviewEntity> review = testService.reviewCheck();
//    List<PlaceEntity> place = testService.placeCheck();
    mav.addObject("review", review);
//    mav.addObject("place", place);
    return mav;
  }
}
