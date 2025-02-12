package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.service.ReviewImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reviewImage")
public class ReviewImageController {

  @Autowired
  private ReviewImageService reviewImageService;

  @RequestMapping("/")
  public String reviewImage(){
    return "reviewImage";
  }
}
