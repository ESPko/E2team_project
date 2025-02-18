package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

  @Autowired
  private ReviewRepository reviewRepository;

  @Override
  public void reviewStar(String reviewComment, double reviewStar){
    reviewRepository.queryWriteReview(reviewComment, reviewStar);
  }
}
