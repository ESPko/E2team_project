package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.service.PlaceImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/placeImage")
public class PlaceImageController {

  @Autowired
  private PlaceImageService placeImageService;

  @RequestMapping("/")
  public String placeImage() {
    return "placeImage";
  }
}
