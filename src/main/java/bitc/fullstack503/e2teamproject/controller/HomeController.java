//package bitc.fullstack503.e2teamproject.controller;
//
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class HomeController {
//
//  @RequestMapping("/")
//  public ModelAndView home() {
//    ModelAndView mav = new ModelAndView("/board/mainPage");
//    mav.addObject("title", "Home Page");
//    return mav;
//  }
//
//  @RequestMapping("/notice")
//  public ModelAndView notice() {
//    ModelAndView mav = new ModelAndView("/board/noticePage");
//    return mav;
//  }
//  @RequestMapping("/crew")
//  public ModelAndView crew() {
//    ModelAndView mav = new ModelAndView("/board/crewPage");
//    return mav;
//  }
//  @RequestMapping("/event")
//  public ModelAndView event() {
//    ModelAndView mav = new ModelAndView("/board/eventPage");
//    return mav;
//  }
//
//  @RequestMapping("/noticedetail")
//  public ModelAndView noticedetail() {
//    ModelAndView mav = new ModelAndView("/board/noticeDetailPage");
//    return mav;
//  }
//
//  @RequestMapping("/manager")
//  public ModelAndView managerPage() {
//    ModelAndView mav = new ModelAndView("/manage/managerPage");
//    return mav;
//  }
//  @RequestMapping("/login")
//  public ModelAndView login() {
//    ModelAndView mav = new ModelAndView("/login/login");
//    return mav;
//  }
//  @RequestMapping("/loginpage")
//  public ModelAndView loginPage(HttpServletRequest request) {
//    ModelAndView mav = new ModelAndView("/login/loginPage");
//
//        // 쿠키에서 아이디가 저장되어 있으면 로그인 페이지에 표시
//    Cookie[] cookies = request.getCookies();
//    String cookieUserId = null;
//    if (cookies != null) {
//      for (Cookie cookie : cookies) {
//        if ("userId".equals(cookie.getName())) {
//          cookieUserId = cookie.getValue();
//        }
//      }
//    }
//    // 쿠키 값 전달
//    request.setAttribute("cookieUserId", cookieUserId);
//
//    return mav;
//  }
//
//  @RequestMapping("/profile")
//  public ModelAndView profile() {
//    ModelAndView mav = new ModelAndView("/login/profile");
//    return mav;
//  }
//  @RequestMapping("/profilepage")
//  public ModelAndView prifilePage() {
//    ModelAndView mav = new ModelAndView("/login/profilePage");
//    return mav;
//  }
//  @RequestMapping("/resister")
//  public ModelAndView resister() {
//    ModelAndView mav = new ModelAndView("/login/resisterPage");
//    return mav;
//  }
//}

