package bitc.fullstack503.e2teamproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Controller
public class RecommandController {

  //  추천 페이지
  @RequestMapping("/rec1")
  public ModelAndView recommand1() {
    return new ModelAndView("/board/recommandPage1");
  }

//  추천 페이지
@RequestMapping("/rec2")
public ModelAndView recommand2() {
  return new ModelAndView("/board/recommandPage2");
}


//  추천 페이지
@RequestMapping("/rec3")
public ModelAndView recommand3() {
  return new ModelAndView("/board/recommandPage3");
}


//  추천 페이지
@RequestMapping("/rec4")
public ModelAndView recommand4() {
  return new ModelAndView("/board/recommandPage4");
}


//  추천 페이지
@RequestMapping("/rec5")
public ModelAndView recommand5() {
  return new ModelAndView("/board/recommandPage5");
}


//  추천 페이지
@RequestMapping("/rec6")
public ModelAndView recommand6() {
  return new ModelAndView("/board/recommandPage6");
}



}
