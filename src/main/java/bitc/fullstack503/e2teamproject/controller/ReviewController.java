package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.DTO.ReviewDTO;
import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import bitc.fullstack503.e2teamproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Controller
@RequestMapping("/review")
public class ReviewController {

  @Autowired
  private ReviewService reviewService;

  @RequestMapping("/")
  public ModelAndView jiHyunStarTest() {
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

  //  리뷰 쓰기
  @ResponseBody
  @RequestMapping("/write/{reviewWrite}/{reviewStar}")
  public void reviewWrite(@PathVariable("reviewWrite") String reviewWrite,
                          @PathVariable("reviewStar") double reviewStar) {
    reviewService.reviewStar(reviewWrite, reviewStar);
  }

  //  리뷰 보기
  @ResponseBody
  @GetMapping("/read")
  public List<ReviewDTO> reviewRead() {
    List<ReviewEntity> readReview = reviewService.readReview();

//    for (ReviewEntity reviewEntity : readReview) {
//      System.out.println("reviewIdx : " + reviewEntity.getReviewIdx());
//      System.out.println("reviewComment : " + reviewEntity.getComment());
//      System.out.println("reviewStar : " + reviewEntity.getStar());
//      System.out.println("reviewUserIdx : " + reviewEntity.getUserReview().getUser_idx());
//      System.out.println("------------------------");
//    }

    return readReview.stream()
            .map(ReviewDTO::fromEntity)
            .collect(Collectors.toList());
  }

//  리뷰 삭제
  @ResponseBody
  @DeleteMapping("/delete/{reviewIdx}")
  public void deleteReview(@PathVariable("reviewIdx") int reviewIdx) {
    System.out.println("reviewIdx : " + reviewIdx);
    System.out.println("리뷰 삭제");
    reviewService.deleteReview(reviewIdx);
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
