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

  // 로그인
  @PostMapping("/loginProcess.do")
  @ResponseBody
  public Map<String, Object> loginProcess(@RequestParam("userId") String userId,
                                          @RequestParam("userPw") String userPw,
                                          @RequestParam(value = "rememberMe", required = false) String rememberMe,
                                          HttpServletRequest request,
                                          HttpServletResponse response) throws Exception {
    Map<String, Object> result = new HashMap<>();

    if (userService.isUserInfo(userId, userPw)) {
      UserEntity user = userService.getUserInfo(userId);
      HttpSession session = request.getSession();
      session.setAttribute("userId", user.getId());
      session.setAttribute("userEmail", user.getEmail());
      session.setAttribute("userLevel", user.getLevel());
      session.setMaxInactiveInterval(60 * 60);


      //  체크박스가 체크된 경우에만 쿠키를 설정
      if ("on".equals(rememberMe)) {
        Cookie cookie = new Cookie("userId", userId);
        cookie.setMaxAge(60 * 60 * 24 * 30); // 30일 동안 유지
        cookie.setPath("/");
        response.addCookie(cookie);
      } else {
        // 체크하지 않았다면 기존 쿠키 삭제
        Cookie cookie = new Cookie("userId", null);
        cookie.setMaxAge(0); // 쿠키 즉시 삭제
        cookie.setPath("/");
        response.addCookie(cookie);
      }

      result.put("status", "success");
      result.put("userLevel", user.getLevel());
    } else {
      result.put("status", "fail");
      result.put("message", "로그인 정보가 올바르지 않습니다.");
    }

    return result;
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


  //  회원가입 처리
  @PostMapping("/signupProcess.do")
  @ResponseBody
  public Map<String, String> signupProcess(@RequestBody Map<String, String> userData) {
    Map<String, String> response = new HashMap<>();

    try {
      String userId = userData.get("userId");
      String userPw = userData.get("userPw");
      String userBirthYear = userData.get("userBirthYear");
      String userPhone = userData.get("userPhone");
      String userEmail = userData.get("userEmail");

      // 생년월일에서 연도(yyyy)만 추출
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

      response.put("status", "success");
    } catch (Exception e) {
      response.put("status", "fail");
      response.put("message", "회원가입 중 오류 발생: " + e.getMessage());
    }

    return response;
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

