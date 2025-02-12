package bitc.fullstack503.e2teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/placeImage")
public class PlaceImageController {

  @RequestMapping("/")
  public String placeImage() {
    return "placeImage";
  }
}
