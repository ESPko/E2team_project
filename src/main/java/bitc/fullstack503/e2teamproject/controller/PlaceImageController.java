package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.entity.PlaceImageEntity;
import bitc.fullstack503.e2teamproject.service.PlaceImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/placeImage")
public class PlaceImageController {

  @Autowired
  private PlaceImageService placeImageService;

  //  뷰만
  @RequestMapping("/")
  public ModelAndView placeImage() {
    return new ModelAndView("/board/jiHyunImageTest");
  }

//  전부 다 확인
  @RequestMapping("/findAll")
  public List<PlaceImageEntity> findAll(){
    List<PlaceImageEntity> findImageAll= placeImageService.findPlaceAll();
    System.out.println(findImageAll);
    return findImageAll;
  }
}
