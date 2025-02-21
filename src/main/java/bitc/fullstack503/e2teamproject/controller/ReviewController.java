package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.DTO.ReviewDTO;
import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import bitc.fullstack503.e2teamproject.service.PlaceService;
import bitc.fullstack503.e2teamproject.service.ReviewService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private PlaceService placeService;

  @RequestMapping("/")
  public ModelAndView jiHyunStarTest(){
    ModelAndView mav = new ModelAndView("/board/jiHyunStarTest");
    return mav;
  }

  //  장소 상세 페이지 테스트
//  @GetMapping("/placeDetail")
//  public ModelAndView getPlaceDetail(@RequestParam("placeIdx") int placeIdx) {
//    List<ReviewEntity> reviews = reviewService.getReviewsByPlace(placeIdx);
//    ModelAndView mav = new ModelAndView("board/placeDetailTest");  // 뷰 이름 설정
//    mav.addObject("reviews", reviews);  // 모델 데이터 추가
//    return mav;
//  }

  @ResponseBody
  @RequestMapping("/write/{reviewWrite}/{reviewStar}")
  public void reviewWrite(@PathVariable("reviewWrite") String reviewWrite,
                          @PathVariable("reviewStar") double reviewStar){
    reviewService.reviewStar(reviewWrite, reviewStar);
  }

  //  리뷰 보기
  @ResponseBody
  @GetMapping("/read/{reviewPlaceIdx}")
  public List<ReviewDTO> reviewRead(@PathVariable("reviewPlaceIdx") int reviewPlaceIdx) {
    List<ReviewEntity> readReview = reviewService.readReview(reviewPlaceIdx);
    return readReview.stream()
            .map(ReviewDTO::fromEntity)
            .collect(Collectors.toList());
  }

//   리뷰 작성 test
//  @PostMapping("/write")
//  @ResponseBody
//  public ResponseEntity<String> writeReview(@RequestParam("placeIdx") int placeIdx,
//                                            @RequestParam("comment") String comment,
//                                            @RequestParam("star") double star,
//                                            HttpSession session) {
//    Integer userId = (Integer) session.getAttribute("userIdx"); // 로그인한 사용자 ID 가져오기
//    if (userId == null) {
//      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
//    }
//    reviewService.saveReview(placeIdx, userId, comment, star);
//    return ResponseEntity.ok("리뷰 작성 완료");
//  }

//  @PostMapping("/write")
//  @ResponseBody
//  public ResponseEntity<String> writeReview(@RequestBody ReviewDTO requestDto, HttpSession session) {
//    Integer userId = (Integer) session.getAttribute("userIdx"); // 로그인한 사용자 ID 가져오기
//    if (userId == null) {
//      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
//    }
//    reviewService.saveReview(requestDto.getPlaceIdx(), userId, requestDto.getComment(), requestDto.getStar());
//    return ResponseEntity.ok("리뷰 작성 완료");
//  }


    //  뷰 페이지
  @GetMapping("/DetailReview")
  public ModelAndView getDetailReview(@RequestParam("placeIdx") int placeIdx) {
    List<ReviewEntity> reviews = reviewService.getReviewsByPlace(placeIdx);


    List<PlaceEntity> places = placeService.findPlaceDetail(placeIdx);

    ModelAndView mav = new ModelAndView("board/DetailReviewPage");  // 뷰 이름 설정
    mav.addObject("reviews", reviews);
    mav.addObject("places", places); // 모델 데이터 추가
    return mav;
  }
}
