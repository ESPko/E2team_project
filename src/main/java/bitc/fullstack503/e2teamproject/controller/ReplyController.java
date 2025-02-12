package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reply")
public class ReplyController {

  @Autowired
  private ReplyService replyService;

  @RequestMapping("/")
  public String reply() {
    return "reply";
  }
}
