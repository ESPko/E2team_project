package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.repository.ReviewImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewImageServiceImpl implements ReviewImageService {

  @Autowired
  private ReviewImageRepository reviewImageRepository;
}
