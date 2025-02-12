package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.repository.BoardImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardImageServiceImpl implements BoardImageService {

  @Autowired
  private BoardImageRepository boardImageRepository;
}
