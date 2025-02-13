package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import bitc.fullstack503.e2teamproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

  @Autowired
  private BoardService boardService;

  //  공지, 이벤트, 인원 모집 보기
  @RequestMapping("/")
  public ModelAndView board() {
    ModelAndView mav = new ModelAndView("/board/jiHyunTest");
    List<BoardEntity> findNoticeList = boardService.findNotice();
    List<BoardEntity> findEventList = boardService.findEvent();
    List<BoardEntity> findPersonList = boardService.findPerson();
    mav.addObject("findNoticeList", findNoticeList);
    mav.addObject("findEventList", findEventList);
    mav.addObject("findPersonList", findPersonList);
    return mav;
  }

  //  공지 쓰기
  @PostMapping("/notice/write")
  public void writeNotice(@RequestParam("noticeTitle") String noticeTitle, @RequestParam("noticeContents") String noticeContents) {
    boardService.writeNotice(noticeTitle, noticeContents);
  }

  //  공지 수정하기
  @PutMapping("/notice/update")
  public void updateNotice(@RequestParam("noticeTitleUpdate") String noticeTitleUpdate,
                           @RequestParam("noticeContentsUpdate") String noticeContentsUpdate,
                           @RequestParam("noticeNumber") int noticeNumber) {
    boardService.updateNotice(noticeTitleUpdate, noticeContentsUpdate, noticeNumber);
  }

//  공지 삭제하기
  @DeleteMapping("/notice/delete")
  public void deleteNotice(@RequestParam("noticeNumberDelete") int noticeNumberDelete){
    boardService.deleteNotice(noticeNumberDelete);
  }
}
