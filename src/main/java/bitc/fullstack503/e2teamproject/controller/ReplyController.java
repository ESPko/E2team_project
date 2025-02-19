package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.DTO.ReplyDTO;
import bitc.fullstack503.e2teamproject.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
  public Object replyShow(@PathVariable("crewBoardIdx") int crewBoardIdx) {
    List<ReplyDTO> replyList = replyService.replyShow(crewBoardIdx)
            .stream()
            .map(ReplyDTO::fromEntity)
            .collect(Collectors.toList());

    Map<String, Object> result = new HashMap<>();
    result.put("replyList", replyList);
    return result;
  }

  //  댓글 쓰기
  @ResponseBody
  @PostMapping("/write/{crewBoardIdx}/{replyWriteComment}")
  public void replyWrite(@PathVariable("crewBoardIdx") int crewBoardIdx,
                         @PathVariable("replyWriteComment") String replyWriteComment) {
    replyService.replyWrite(crewBoardIdx, replyWriteComment);
  }

  //  댓글 삭제
  @ResponseBody
  @DeleteMapping("/delete/{replyIdx}")
  public void replyDelete(@PathVariable("replyIdx") int replyIdx) {
    replyService.replyDelete(replyIdx);
  }
}
