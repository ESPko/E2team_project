package bitc.fullstack503.e2teamproject.controller;


import bitc.fullstack503.e2teamproject.entity.UserEntity;
import bitc.fullstack503.e2teamproject.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/")
  public String login(HttpServletRequest request) {

    // 쿠키에서 아이디가 저장되어 있으면 로그인 페이지에 표시
    Cookie[] cookies = request.getCookies();
    String cookieUserId = null;
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if ("userId".equals(cookie.getName())) {
          cookieUserId = cookie.getValue();
        }
      }
    }
    // 쿠키 값 전달
    request.setAttribute("cookieUserId", cookieUserId);
    return "login/loginPage";
  }

//  로그인
  @PostMapping("/loginProcess.do")
  public String loginProcess(@RequestParam("userId") String userId,
                             @RequestParam("userPw") String userPw,
                             @RequestParam(value = "rememberMe", required = false) String rememberMe,
                             HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
    if (userService.isUserInfo(userId, userPw)) {

      UserEntity user = userService.getUserInfo(userId);
      HttpSession session = request.getSession();
      session.setAttribute("userId", user.getId());
      session.setAttribute("userEmail", user.getEmail());
      session.setAttribute("userLevel", user.getLevel());
      session.setMaxInactiveInterval(60 * 60);

      // "아이디 저장" 체크박스가 선택되었으면 쿠키에 저장
      if (rememberMe != null) {
        Cookie cookie = new Cookie("userId", userId);
        cookie.setMaxAge(60 * 60 * 24 * 30); // 30일 동안 유효
        cookie.setPath("/"); // 모든 경로에서 쿠키 접근 가능
        response.addCookie(cookie);
      }

      if (user.getLevel() == 1) {
        return "redirect:/board/manager"; // 관리자 페이지
      }
      return "redirect:/user/";
    } else {
      return "redirect:/user/?errMsg=" + URLEncoder.encode("로그인 정보가 다릅니다.", "UTF-8");
    }
  }

//   로그아웃
  @RequestMapping("/logout")
  public String logout(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    session.invalidate();

    // 로그아웃 시 쿠키 삭제
    Cookie cookie = new Cookie("userId", null);
    cookie.setMaxAge(0); // 쿠키 삭제
    cookie.setPath("/"); // 모든 경로에서 쿠키 접근 가능
    response.addCookie(cookie);

    return "redirect:/user/";
  }

  // 회원가입 처리
  @PostMapping("/signupProcess.do")
  public String signupProcess(@RequestParam("userId") String userId,
                              @RequestParam("userPw") String userPw,
                              @RequestParam("userBirthYear") String userBirthYear,
                              @RequestParam("userPhone") String userPhone,
                              @RequestParam("userEmail") String userEmail
                             ) throws Exception {

    // yyyy-MM-dd 형식에서 연도(yyyy)만 추출
    String birthYear = userBirthYear.split("-")[0];

    UserEntity newUser = UserEntity.builder()
            .id(userId)
            .password(userPw)
            .birthYear(birthYear)
            .phone(userPhone)
            .email(userEmail)
            .createDate(LocalDateTime.now())
            .level((byte) 0) // 일반 사용자
            .build();

    userService.registerUser(newUser);

    return "redirect:/user/"; // 회원가입 후 로그인 페이지 이동

  }



// 아이디 중복 체크
  @GetMapping("/checkDuplicate")
  @ResponseBody
  public Map<String, String> checkDuplicate(@RequestParam("userId") String userId) {
    boolean exists = userService.isUserExists(userId);
    Map<String, String> response = new HashMap<>();
    response.put("status", exists ? "duplicate" : "available");
    return response;
  }


}

