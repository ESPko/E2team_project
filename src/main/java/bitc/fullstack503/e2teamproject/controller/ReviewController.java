package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import bitc.fullstack503.e2teamproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Controller
@RequestMapping("/review")
public class ReviewController {

  @Autowired
  private ReviewService reviewService;

  @RequestMapping("/")
  public ModelAndView jiHyunStarTest(){
    ModelAndView mav = new ModelAndView("/board/jiHyunStarTest");
    return mav;
  }

  @ResponseBody
  @RequestMapping("/write/{reviewWrite}/{reviewStar}")
  public void reviewWrite(@PathVariable("reviewWrite") String reviewWrite,
                          @PathVariable("reviewStar") double reviewStar){
    System.out.println("reviewWrite");
    System.out.println(reviewWrite);
    System.out.println(reviewStar);
    reviewService.reviewStar(reviewWrite, reviewStar);
  }
}
