package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
@Controller
@RequestMapping("/reply")
public class ReplyController {

  @Autowired
  private ReplyService replyService;

  @ResponseBody
  @PostMapping("/write/{crewBoardIdx}/{replyWriteComment}")
  public void replyWrite(@PathVariable("crewBoardIdx") int crewBoardIdx,
                         @PathVariable("replyWriteComment") String replyWriteComment) {
    System.out.println(crewBoardIdx);
    System.out.println(replyWriteComment);
    replyService.writeReply(crewBoardIdx, replyWriteComment);
  }
}
