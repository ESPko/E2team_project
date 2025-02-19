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
    ModelAndView mav = new ModelAndView("/board/jiHyunImageTest");
    List<PlaceImageEntity> findImageList= placeImageService.findPlaceAll();
    System.out.println(findImageList);
    mav.addObject("findImageList", findImageList);
    return mav;
  }

//  전부 다 확인
//  @RequestMapping("/findAll")
//  public List<PlaceImageEntity> findAll(){
//    List<PlaceImageEntity> findImageAll= placeImageService.findPlaceAll();
//    System.out.println(findImageAll);
//    return findImageAll;
//  }
}
