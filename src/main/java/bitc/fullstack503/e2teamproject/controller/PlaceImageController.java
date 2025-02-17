package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.service.PlaceImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/placeImage")
public class PlaceImageController {

  @Autowired
  private PlaceImageService placeImageService;

  @RequestMapping("/")
  public ModelAndView placeImage() {
    ModelAndView mav = new ModelAndView("jiHyunStarTest");
    return mav;
  }
}
