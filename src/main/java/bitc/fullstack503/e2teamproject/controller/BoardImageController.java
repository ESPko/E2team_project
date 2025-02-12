package bitc.fullstack503.e2teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boardImage")
public class BoardImageController {

  @RequestMapping("/")
  public String boardImage() {
    return "boardImage";
  }
}
