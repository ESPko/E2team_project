package bitc.fullstack503.e2teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @RequestMapping("/")
  public ModelAndView home() {
    ModelAndView mav = new ModelAndView("/board/mainPage");
    mav.addObject("title", "Home Page");
    return mav;
  }
  @RequestMapping("/notice")
  public ModelAndView notice() {
    ModelAndView mav = new ModelAndView("/board/noticePage");
    mav.addObject("title", "Home Page");
    return mav;
  }
  @RequestMapping("/crew")
  public ModelAndView crew() {
    ModelAndView mav = new ModelAndView("/board/crewPage");
    mav.addObject("title", "Home Page");
    return mav;
  }
  @RequestMapping("/event")
  public ModelAndView event() {
    ModelAndView mav = new ModelAndView("/board/eventPage");
    mav.addObject("title", "Home Page");
    return mav;
  }
  @RequestMapping("/noticedetail")
  public ModelAndView noticedetail() {
    ModelAndView mav = new ModelAndView("/board/noticeDetailPage");
    mav.addObject("title", "Home Page");
    return mav;
  }

}

