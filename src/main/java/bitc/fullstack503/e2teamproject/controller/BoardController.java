package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import bitc.fullstack503.e2teamproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RestController
@RequestMapping("/board")
public class BoardController {

  @Autowired
  private BoardService boardService;

  //  공지 보기
  @RequestMapping("/notice/read")
  public ModelAndView noticeRead() {
    ModelAndView mav = new ModelAndView("/board/noticePage");
    List<BoardEntity> findNoticeList = boardService.findNotice();
    mav.addObject("findNoticeList", findNoticeList);
    return mav;
  }

  //  공지 쓰기
  @ResponseBody
  @PostMapping("/notice/write")
  public void writeNotice(@RequestParam("noticeTitle") String noticeTitle, @RequestParam("noticeContents") String noticeContents) {
    boardService.writeNotice(noticeTitle, noticeContents);
  }

  //  공지 수정하기
  @ResponseBody
  @PutMapping("/notice/update")
  public void updateNotice(@RequestParam("noticeTitleUpdate") String noticeTitleUpdate,
                           @RequestParam("noticeContentsUpdate") String noticeContentsUpdate,
                           @RequestParam("noticeNumber") int noticeNumber) {
    boardService.updateNotice(noticeTitleUpdate, noticeContentsUpdate, noticeNumber);
  }

  //  공지 삭제하기
  @ResponseBody
  @DeleteMapping("/notice/delete")
  public void deleteNotice(@RequestParam("noticeNumberDelete") int noticeNumberDelete) {
    boardService.deleteNotice(noticeNumberDelete);
  }

  //  이벤트 보기
  @RequestMapping("/event/read")
  public ModelAndView eventRead() {
    ModelAndView mav = new ModelAndView("/board/eventPage");
    List<BoardEntity> findEventList = boardService.findEvent();
    mav.addObject("findEventList", findEventList);
    return mav;
  }

  //  이벤트 쓰기
  @ResponseBody
  @PostMapping("/event/write")
  public void writeEvent(@RequestParam("eventTitleCreate") String eventTitleCreate,
                         @RequestParam("eventContentsCreate") String eventContentsCreate) {
    boardService.writeEvent(eventTitleCreate, eventContentsCreate);
  }

  //  이벤트 수정하기
  @ResponseBody
  @PutMapping("/event/update")
  public void updateEvent(@RequestParam("eventTitleUpdate") String eventTitleUpdate,
                          @RequestParam("eventContentsUpdate") String eventContentsUpdate,
                          @RequestParam("eventNumberUpdate") int eventNumberUpdate) {
    boardService.updateEvent(eventTitleUpdate, eventContentsUpdate, eventNumberUpdate);
  }

  //  이벤트 삭제하기
  @ResponseBody
  @DeleteMapping("/event/delete")
  public void deleteEvent(@RequestParam("eventNumberDelete") int eventNumberDelete) {
    boardService.deleteEvent(eventNumberDelete);
  }

  //  인원 모집 보기
  @RequestMapping("/crew/read")
  public ModelAndView crewRead() {
    ModelAndView mav = new ModelAndView("/board/crewPage");
    List<BoardEntity> findPersonList = boardService.findPerson();
    mav.addObject("findPersonList", findPersonList);
    return mav;
  }

//  관리자 페이지
  @RequestMapping("/manager")
  public ModelAndView manager() {
    return new ModelAndView("/manage/managerPage");
  }

  // 회원가입 페이지
  @RequestMapping("/signup")
  public String signup() {
    return "login/registerPage";  // 회원가입 페이지로 이동
  }

}
