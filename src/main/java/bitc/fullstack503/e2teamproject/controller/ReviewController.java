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

  //  장소 상세 페이지 테스트
  @GetMapping("/placeDetail")
  public ModelAndView getPlaceDetail(@RequestParam("placeIdx") int placeIdx) {
    List<ReviewEntity> reviews = reviewService.getReviewsByPlace(placeIdx);
    ModelAndView mav = new ModelAndView("board/placeDetailTest");  // 뷰 이름 설정
    mav.addObject("reviews", reviews);  // 모델 데이터 추가
    return mav;
  }

  @ResponseBody
  @RequestMapping("/write/{reviewWrite}/{reviewStar}")
  public void reviewWrite(@PathVariable("reviewWrite") String reviewWrite,
                          @PathVariable("reviewStar") double reviewStar){
    reviewService.reviewStar(reviewWrite, reviewStar);
  }


//  리뷰 상세 테스트
//  @GetMapping("/DetailReview")
//  public ModelAndView getDetailReview(@RequestParam("placeIdx") int placeIdx) {
//    List<ReviewEntity> reviews = reviewService.getReviewsByPlace(placeIdx);
//    ModelAndView mav = new ModelAndView("board/DetailReviewPage");  // 뷰 이름 설정
//    mav.addObject("reviews", reviews);  // 모델 데이터 추가
//    return mav;
//  }
}
