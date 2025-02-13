package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {

  @Autowired
  private BoardService boardService;

  @RequestMapping("/")
  public String board() {
    return "/board/board";
  }

//  관리자 페이지
  @RequestMapping("/manager")
  public ModelAndView manager() {
    return new ModelAndView("/manage/managerPage");
  }

  // 회원가입 페이지
  @RequestMapping("/signup")
  public String signup() {
    return "login/signup";  // 회원가입 페이지로 이동
  }

}
