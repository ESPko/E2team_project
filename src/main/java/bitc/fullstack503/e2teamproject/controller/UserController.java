package bitc.fullstack503.e2teamproject.controller;

<<<<<<< HEAD
import bitc.fullstack503.e2teamproject.entity.UserEntity;
import bitc.fullstack503.e2teamproject.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
=======
import bitc.fullstack503.e2teamproject.service.UserService;
>>>>>>> 76f865e63340db06a4e01bb474157331518fc843
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;


@Controller
@RequestMapping("/board/login")
public class UserController {

  @Autowired
  private UserService userService;

<<<<<<< HEAD
  // 로그인 페이지 (단순 View)
  @RequestMapping("/login.do")
  public String login() {
    return "login/login";
=======
  @RequestMapping("/")
  public String user() {
    return "user";
>>>>>>> 76f865e63340db06a4e01bb474157331518fc843
  }

  @RequestMapping("/loginProcess.do")
  public String loginProcess(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw, HttpServletRequest request)
          throws Exception {

    boolean result = userService.isUserInfo(userId, userPw);

    if (result == true) {

      UserEntity user = userService.getUserInfo(userId);

      HttpSession session = request.getSession();

      session.setAttribute("userId", user.getId());
      session.setAttribute("userEmail", user.getEmail());

      session.setMaxInactiveInterval(60 * 60 * 1);

      return "index";
    }
    else {

      return "redirect:/board/login/login.do?errMsg=" + URLEncoder.encode("로그인 정보가 다릅니다.", "UTF-8");
    }

  }

  @RequestMapping("/logout.do")
  public String logout(HttpServletRequest request) {

    HttpSession session = request.getSession();

    session.removeAttribute("userId");
    session.removeAttribute("userName");
    session.removeAttribute("userEmail");

    session.invalidate();

    return "index";
  }


}
