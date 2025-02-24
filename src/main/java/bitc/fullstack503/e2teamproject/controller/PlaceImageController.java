package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.entity.PlaceImageEntity;
import bitc.fullstack503.e2teamproject.service.PlaceImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
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
    mav.addObject("findImageList", findImageList);
    return mav;
  }

  @ResponseBody
  @GetMapping("/findPlaceImage")
  public ResponseEntity<List<PlaceImageEntity>> findPlaceImage() {
    List<PlaceImageEntity> findPlaceImageList = placeImageService.findPlaceImage();
    return ResponseEntity.ok(findPlaceImageList);
  }

}
