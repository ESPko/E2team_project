package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.service.BoardImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boardImage")
public class BoardImageController {

  @Autowired
  private BoardImageService boardImageService;

  @RequestMapping("/")
  public String boardImage() {
    return "boardImage";
  }
}
