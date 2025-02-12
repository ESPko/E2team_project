package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

  @Autowired
  private BoardService boardService;

  @RequestMapping("/")
  public String board() {
    return "/board/board";
  }
}
