package bitc.fullstack503.e2teamproject.controller;


import bitc.fullstack503.e2teamproject.entity.UserEntity;
import bitc.fullstack503.e2teamproject.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.net.URLEncoder;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/")
  public String login() {
    return "login/loginPage";
  }

  @PostMapping("/loginProcess.do")
  public String loginProcess(@RequestParam("userId") String userId,
                             @RequestParam("userPw") String userPw,
                             HttpServletRequest request) throws Exception {
    if (userService.isUserInfo(userId, userPw)) {

      UserEntity user = userService.getUserInfo(userId);
      HttpSession session = request.getSession();
      session.setAttribute("userId", user.getId());
      session.setAttribute("userEmail", user.getEmail());
      session.setAttribute("userLevel", user.getLevel());
      session.setMaxInactiveInterval(60 * 60);

      if (user.getLevel() == 1) {
        return "redirect:/board/manager"; // 관리자 페이지
      }
      return "redirect:/user/";
    } else {
      return "redirect:/user/?errMsg=" + URLEncoder.encode("로그인 정보가 다릅니다.", "UTF-8");
    }
  }

  @RequestMapping("/logout")
  public String logout(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.invalidate();
    return "redirect:/user/";
  }
}

