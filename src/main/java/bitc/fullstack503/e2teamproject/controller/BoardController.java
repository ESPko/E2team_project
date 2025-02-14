package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import bitc.fullstack503.e2teamproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
>>>>>>> ab577824c1aa32078ca1f1f5d21424472fc593c0
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
>>>>>>> 945e405062063ba14e54436d47b23d687340b012
=======

>>>>>>> ab577824c1aa32078ca1f1f5d21424472fc593c0

@Controller
@RequestMapping("/board")
public class BoardController {

  @Autowired
  private BoardService boardService;

//  심지현 테스트용
  @RequestMapping("/")
  public ModelAndView simJiHyun(){
    ModelAndView mav = new ModelAndView("/board/jiHyunTest");
    List<BoardEntity> findNoticeList = boardService.findNotice();
    List<BoardEntity> findEventList = boardService.findEvent();
    List<BoardEntity> findCrewList = boardService.findCrew();
    mav.addObject("findNoticeList", findNoticeList);
    mav.addObject("findEventList", findEventList);
    mav.addObject("findCrewList", findCrewList);
    return mav;
  }

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
  public String writeNotice(@RequestParam("noticeTitle") String noticeTitle, @RequestParam("noticeContents") String noticeContents) {
    boardService.writeNotice(noticeTitle, noticeContents);
    return "/board/";
  }

  //  공지 수정하기
  @ResponseBody
  @PutMapping("/notice/update")
  public String updateNotice(@RequestParam(value = "noticeTitleUpdate", required = false) String noticeTitleUpdate,
                           @RequestParam(value = "noticeContentsUpdate", required = false) String noticeContentsUpdate,
                           @RequestParam(value = "noticeNumberUpdate", required = false) int noticeNumberUpdate) {
    boardService.updateNotice(noticeTitleUpdate, noticeContentsUpdate, noticeNumberUpdate);
    return "/board/";
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
    List<BoardEntity> findCrewList = boardService.findCrew();
    mav.addObject("findCrewList", findCrewList);
    return mav;
  }

<<<<<<< HEAD
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

=======
  //  이벤트 쓰기
  @ResponseBody
  @PostMapping("/crew/write")
  public void writeCrew(@RequestParam("crewTitleCreate") String crewTitleCreate,
                         @RequestParam("crewContentsCreate") String crewContentsCreate) {
    boardService.writeCrew(crewTitleCreate, crewContentsCreate);
  }

  //  이벤트 수정하기
  @ResponseBody
  @PutMapping("/crew/update")
  public void updateCrew(@RequestParam("crewTitleUpdate") String crewTitleUpdate,
                          @RequestParam("crewContentsUpdate") String crewContentsUpdate,
                          @RequestParam("crewNumberUpdate") int crewNumberUpdate) {
    boardService.updateCrew(crewTitleUpdate, crewContentsUpdate, crewNumberUpdate);
  }

  //  이벤트 삭제하기
  @ResponseBody
  @DeleteMapping("/crew/delete")
  public void deleteCrew(@RequestParam("crewNumberDelete") int crewNumberDelete) {
    boardService.deleteCrew(crewNumberDelete);
  }
>>>>>>> simJiHyun
}
