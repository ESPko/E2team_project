package bitc.fullstack503.e2teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reviewImage")
public class ReviewImageController {

  @RequestMapping("/")
  public String reviewImage(){
    return "reviewImage";
  }
}
