package bitc.fullstack503.e2teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @RequestMapping("/noticedetail")
  public ModelAndView noticedetail() {
    ModelAndView mav = new ModelAndView("/board/noticeDetailPage");
    mav.addObject("title", "Home Page");
    return mav;
  }
}

