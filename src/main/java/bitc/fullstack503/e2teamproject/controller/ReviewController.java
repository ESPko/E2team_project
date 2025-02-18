//package bitc.fullstack503.e2teamproject.controller;
//
//import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
//import bitc.fullstack503.e2teamproject.service.ReviewService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/review")
//public class ReviewController {
//
//  @Autowired
//  private ReviewService reviewService;
//}




package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import bitc.fullstack503.e2teamproject.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@Controller
@RequiredArgsConstructor
public class ReviewController {
  private final ReviewService reviewService;

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

//  해당 장소 상세 페이지 테스트
  @GetMapping("/placeDetail")
  public String getPlaceDetail(@RequestParam("placeIdx") int placeIdx, Model model) {
    List<ReviewEntity> reviews = reviewService.getReviewsByPlace(placeIdx);
    model.addAttribute("reviews", reviews);
    return "board/placeDetailTest";
  }

  // 리뷰 삭제 요청 처리 테스트
  @DeleteMapping("/{reviewIdx}")
  public ResponseEntity<String> deleteReview(@PathVariable int reviewIdx) {
    reviewService.deleteReview(reviewIdx);
    return ResponseEntity.ok("리뷰가 삭제되었습니다.");

  }
}

