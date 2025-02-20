package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.DTO.ReplyDTO;
import bitc.fullstack503.e2teamproject.service.ReplyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/reply")
public class ReplyController {

  @Autowired
  private ReplyService replyService;

  //  댓글 보기
  @ResponseBody
  @GetMapping("/list/{crewBoardIdx}")
  public Object replyShow(@PathVariable("crewBoardIdx") int crewBoardIdx,
                          HttpServletRequest request) {
    List<ReplyDTO> replyList = replyService.replyShow(crewBoardIdx)
            .stream()
            .map(ReplyDTO::fromEntity)
            .collect(Collectors.toList());

    Map<String, Object> result = new HashMap<>();
    result.put("replyList", replyList);

    HttpSession session = request.getSession();
    String userId = (String) session.getAttribute("userId");
    System.out.println(userId);

    return result;
  }

  //  댓글 쓰기
  @ResponseBody
  @PostMapping("/write/{crewBoardIdx}/{replyWriteComment}")
  public void replyWrite(@PathVariable("crewBoardIdx") int crewBoardIdx,
                         @PathVariable("replyWriteComment") String replyWriteComment,
                         HttpServletRequest request) {
    HttpSession session = request.getSession();
    Integer replyUserIdx = (Integer) session.getAttribute("userIdx");
    System.out.println(replyUserIdx);

//    replyService.replyWrite(crewBoardIdx, replyUserIdx, replyWriteComment);
  }

  //  댓글 삭제
  @ResponseBody
  @DeleteMapping("/delete/{replyIdx}")
  public void replyDelete(@PathVariable("replyIdx") int replyIdx) {
    replyService.replyDelete(replyIdx);
  }
}
