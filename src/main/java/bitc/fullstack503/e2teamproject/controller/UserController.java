package bitc.fullstack503.e2teamproject.controller;


import bitc.fullstack503.e2teamproject.entity.UserEntity;
import bitc.fullstack503.e2teamproject.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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


  // 로그인 페이지 (단순 View)
  @RequestMapping("/login.do")
  public String login() {
    return "login/login";

  }

    @RequestMapping("/logout.do")
    public String logout (HttpServletRequest request){

      HttpSession session = request.getSession();

      session.removeAttribute("userId");
      session.removeAttribute("userName");
      session.removeAttribute("userEmail");

      session.invalidate();

      return "index";
    }


  }

