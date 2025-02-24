package bitc.fullstack503.e2teamproject.controller;


import bitc.fullstack503.e2teamproject.entity.UserEntity;
import bitc.fullstack503.e2teamproject.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
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

      session.setAttribute("userIdx", user.getUser_idx());
      session.setAttribute("userId", user.getId());
      session.setAttribute("userName", user.getName());
      session.setAttribute("userEmail", user.getEmail());
      session.setAttribute("userLevel", user.getLevel());
      session.setMaxInactiveInterval(60 * 60);

//      세션 잘 들어오는지 확인용
      System.out.println("userIdx : " + session.getAttribute("userIdx"));
      System.out.println("userId : " + session.getAttribute("userId"));

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

    return "redirect:/";
  }

  //  회원가입 처리
  @PostMapping("/signupProcess.do")
  @ResponseBody
  public Map<String, String> signupProcess(@RequestBody Map<String, String> userData) {
    Map<String, String> response = new HashMap<>();
    try {

      String userName = userData.get("userName");
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
              .name(userName)
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

  //  관리자 페이지
  @RequestMapping("/manager")
  public ModelAndView managerPage() {
    ModelAndView mav = new ModelAndView("/manage/managerPage");
    return mav;
  }

  //  관리자 페이지 - 회원관리
  @RequestMapping("/member")
  public ModelAndView member() {
    ModelAndView mav = new ModelAndView("/manage/memberManage");
    List<UserEntity> userList = userService.getNonAdminUsers(); // 수정된 부분
    mav.addObject("users", userList);
    return mav;
  }

  //  아이디 삭제
  @DeleteMapping("/delete/{id}")
  @ResponseBody
  public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
    userService.deleteUserById(id);
    return ResponseEntity.ok("삭제 완료");
  }

  // 비밀번호 변경
  @PostMapping("/updatePassword")
  public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> requestData, HttpServletRequest request) {
    HttpSession session = request.getSession();
    String userId = (String) session.getAttribute("userId");

    if (userId == null) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
    }

    String newPassword = requestData.get("password");
    userService.updateUserPassword(userId, newPassword);
    return ResponseEntity.ok("비밀번호 변경 성공");
  }

  // 휴대폰번호 변경
  @PostMapping("/updatePhone")
  public ResponseEntity<String> updatePhone(@RequestBody Map<String, String> requestData, HttpServletRequest request) {
    HttpSession session = request.getSession();
    String userId = (String) session.getAttribute("userId");

    if (userId == null) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
    }

    String newPhone = requestData.get("phone");
    userService.updateUserPhone(userId, newPhone);
    return ResponseEntity.ok("휴대폰번호 변경 성공");
  }
}

