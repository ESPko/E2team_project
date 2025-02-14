package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import bitc.fullstack503.e2teamproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@RestController
@Controller
public class BoardController {

  @Autowired
  private BoardService boardService;

  //  심지현 테스트용
  @RequestMapping("/jiHyunTest")
  public ModelAndView simJiHyun() {
    ModelAndView mav = new ModelAndView("/board/jiHyunTest");
    List<BoardEntity> findNoticeList = boardService.findNotice();
    List<BoardEntity> findEventList = boardService.findEvent();
    List<BoardEntity> findCrewList = boardService.findCrew();
    mav.addObject("findNoticeList", findNoticeList);
    mav.addObject("findEventList", findEventList);
    mav.addObject("findCrewList", findCrewList);
    return mav;
  }

  //  메인 페이지
  @RequestMapping("/")
  public ModelAndView home() {
    return new ModelAndView("/board/mainPage");
  }

  //  공지 보기
  @RequestMapping("/notice")
  public ModelAndView noticeRead() {
    ModelAndView mav = new ModelAndView("/board/noticePage");
    List<BoardEntity> findNoticeList = boardService.findNotice();
    mav.addObject("findNoticeList", findNoticeList);
    return mav;
  }

  //  공지 네개씩만 보기
  @ResponseBody
  @RequestMapping("/notice/four")
  public List<BoardEntity> noticeReadFour(){
    return boardService.findNoticeFour();
  }

  //  공지 상세 보기
  @RequestMapping("/notice/{boardIdx}")
  public ModelAndView noticeReadMore(@PathVariable("boardIdx") int boardIdx) {
    ModelAndView mav = new ModelAndView("/board/noticeDetailPage");
    BoardEntity notice = boardService.findNoticeById(boardIdx);
    mav.addObject("notice", notice);
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
  public void updateNotice(@RequestParam(value = "noticeTitleUpdate") String noticeTitleUpdate,
                           @RequestParam(value = "noticeContentsUpdate") String noticeContentsUpdate,
                           @RequestParam(value = "noticeNumberUpdate") int noticeNumberUpdate) {
    boardService.updateNotice(noticeTitleUpdate, noticeContentsUpdate, noticeNumberUpdate);
  }

  //  공지 삭제하기
  @ResponseBody
  @DeleteMapping("/notice/delete")
  public void deleteNotice(@RequestParam("noticeNumberDelete") int noticeNumberDelete) {
    boardService.deleteNotice(noticeNumberDelete);
  }

  //  이벤트 보기
  @RequestMapping("/event")
  public ModelAndView eventRead() {
    ModelAndView mav = new ModelAndView("/board/eventPage");
    List<BoardEntity> findEventList = boardService.findEvent();
    mav.addObject("findEventList", findEventList);
    return mav;
  }

  // 이벤트 네개씩만 보기
  @ResponseBody
  @RequestMapping("/event/four")
  public List<BoardEntity> eventReadFour(){
    return boardService.findEventFour();
  }

  //  이벤트 상세보기
  @RequestMapping("/event/{boardIdx}")
  public ModelAndView eventReadMore(@PathVariable("boardIdx") int boardIdx) {
    ModelAndView mav = new ModelAndView("/board/eventDetailPage");
    BoardEntity event = boardService.findNoticeById(boardIdx);
    mav.addObject("event", event);
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
  @RequestMapping("/crew")
  public ModelAndView crewRead() {
    ModelAndView mav = new ModelAndView("/board/crewPage");
    List<BoardEntity> findCrewList = boardService.findCrew();
    mav.addObject("findCrewList", findCrewList);
    return mav;
  }

  //  인원 모집 상세보기
  @RequestMapping("/crew/{boardIdx}")
  public ModelAndView crewReadMore(@PathVariable("boardIdx") int boardIdx) {
    ModelAndView mav = new ModelAndView("/board/crewDetailPage");
    BoardEntity crew = boardService.findNoticeById(boardIdx);
    mav.addObject("crew", crew);
    return mav;
  }

  //  인원 모집 쓰기
  @ResponseBody
  @PostMapping("/crew/write")
  public void writeCrew(@RequestParam("crewTitleCreate") String crewTitleCreate,
                        @RequestParam("crewContentsCreate") String crewContentsCreate) {
    boardService.writeCrew(crewTitleCreate, crewContentsCreate);
  }

  //  인원 모집 수정하기
  @ResponseBody
  @PutMapping("/crew/update")
  public void updateCrew(@RequestParam("crewTitleUpdate") String crewTitleUpdate,
                         @RequestParam("crewContentsUpdate") String crewContentsUpdate,
                         @RequestParam("crewNumberUpdate") int crewNumberUpdate) {
    boardService.updateCrew(crewTitleUpdate, crewContentsUpdate, crewNumberUpdate);
  }

  //  인원 모집 삭제하기
  @ResponseBody
  @DeleteMapping("/crew/delete")
  public void deleteCrew(@RequestParam("crewNumberDelete") int crewNumberDelete) {
    boardService.deleteCrew(crewNumberDelete);
  }
}
