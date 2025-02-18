package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.ReviewEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ReviewService {
  //  리뷰 쓰기(실험용)
  void reviewStar(@RequestParam("reviewComment") String reviewComment,
                  @RequestParam("reviewStar") double reviewStar);
}
