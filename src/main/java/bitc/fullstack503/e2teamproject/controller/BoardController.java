package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.entity.*;
import bitc.fullstack503.e2teamproject.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Controller
public class BoardController {

  @Autowired
  private BoardService boardService;

  @Autowired
  private BoardImageService boardImageService;
    @Autowired
    private ReplyService replyService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;

  //  심지현 crud 테스트용
  @ResponseBody
  @RequestMapping("/jiHyunCRUDTest")
  public ModelAndView jiHyunCRUDTest() {
    ModelAndView mav = new ModelAndView("/board/jiHyunCRUDTest");
//    List<BoardEntity> findNoticeList = boardService.findNotice();
//    List<BoardEntity> findEventList = boardService.findEvent();
//    List<BoardEntity> findCrewList = boardService.findCrew();
//    mav.addObject("findNoticeList", findNoticeList);
//    mav.addObject("findEventList", findEventList);
//    mav.addObject("findCrewList", findCrewList);
    return mav;
  }

  // 프로필
  @RequestMapping("/pro")
  public ModelAndView profile(HttpServletRequest request) {

    HttpSession session = request.getSession();
    String userId = (String) session.getAttribute("userId");
    String userPw = (String) session.getAttribute("userPw");
    String userEmail = (String) session.getAttribute("userEmail");


    ModelAndView mav = new ModelAndView("/login/profilePage");

    if (userId != null) {
      UserEntity user = userService.getUserInfo(userId);
      mav.addObject("user", user);
      mav.addObject("userEmail", userEmail);
    }

    return mav;
  }

  // 회원가입 페이지
  @RequestMapping("/regist")
  public ModelAndView regist() {
    return new ModelAndView("/login/registerPage");
  }

  //  추천 페이지
  @RequestMapping("/rec")
  public ModelAndView recommand() {
    return new ModelAndView("/board/recommandPage");
  }

  //  메인 페이지
  @RequestMapping("/")
  public ModelAndView home() {
    return new ModelAndView("/board/mainPage");
  }

  //  메인 페이지2
  @RequestMapping("/detail")
  public ModelAndView mainDetail() {
    return new ModelAndView("/board/mainDetailPage");
  }

  //  공지 보기
  @RequestMapping("/notice")
  public ModelAndView noticeRead(@RequestParam(value = "page", defaultValue = "0") int page) {
    ModelAndView mav = new ModelAndView("/board/noticePage");
    Page<BoardEntity> findNoticeList = boardService.findNotice(page);
    mav.addObject("findNoticeList", findNoticeList);
    return mav;
  }

  //  공지 네개씩만 보기
  @ResponseBody
  @RequestMapping("/notice/four")
  public List<BoardEntity> noticeReadFour() {
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
  public void writeNotice(@RequestParam("noticeTitle") String noticeTitle,
                          @RequestParam("noticeContents") String noticeContents) {
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
  public ModelAndView eventRead(@RequestParam(value = "page", defaultValue = "0") int page) {
    ModelAndView mav = new ModelAndView("/board/eventPage");
    Page<BoardEntity> findEventList = boardService.findEvent(page);
    mav.addObject("findEventList", findEventList);
    return mav;
  }

  // 이벤트 네개씩만 보기
  @ResponseBody
  @RequestMapping("/event/four")
  public List<BoardEntity> eventReadFour() {
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
  public ModelAndView crewRead(@RequestParam(value = "page", defaultValue = "0") int page,
                               HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("/board/crewPage");
    Page<BoardEntity> findCrewList = boardService.findCrew(page);
    mav.addObject("findCrewList", findCrewList);

    HttpSession session = request.getSession();
    String userIdx = session.getAttribute("userIdx").toString();
    String userId = session.getAttribute("userId").toString();
    System.out.println("userIdx : " + userIdx);
    System.out.println("userId : " + userId);
    return mav;
  }

  //  인원 모집 상세보기
  @RequestMapping("/crew/{boardIdx}")
  public ModelAndView crewReadMore(@PathVariable("boardIdx") int boardIdx,
                                   HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("/board/crewDetailPage");
    BoardEntity crew = boardService.findNoticeById(boardIdx);
    mav.addObject("crew", crew);

    HttpSession session = request.getSession();
    String userIdx = session.getAttribute("userIdx").toString();
    String userId = session.getAttribute("userId").toString();
    System.out.println("userIdx : " + userIdx);
    System.out.println("userId : " + userId);
    return mav;
  }

  //  인원 모집 쓰기 뷰
  @GetMapping("/crew/write")
  public ModelAndView writeCrewView(HttpServletRequest request) {
//    HttpSession session = request.getSession();
//    String userIdx = session.getAttribute("userIdx").toString();
//    String userId = session.getAttribute("userId").toString();
//    System.out.println("userIdx : " + userIdx);
//    System.out.println("userId : " + userId);
    return new ModelAndView("/board/crewWritePage");
  }

  //  인원 모집 쓰기
  @ResponseBody
  @PostMapping("/crew/write")
  public void writeCrew(@RequestParam("crewTitleCreate") String crewTitleCreate,
                        @RequestParam("crewContentsCreate") String crewContentsCreate,
                        HttpServletRequest request) {
    HttpSession session = request.getSession();
    int userIdx = (int) session.getAttribute("userIdx");
    String trimCrewContentsCreate = crewContentsCreate.trim();

//    System.out.println("userIdx : " + userIdx);
//    System.out.println("crewTitleCreate : " + crewTitleCreate);
//    System.out.println("crewContentsCreate : " + crewContentsCreate);
//    System.out.println("trimCrewContentsCreate : " + trimCrewContentsCreate);
    boardService.writeCrew(userIdx, crewTitleCreate, trimCrewContentsCreate);
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
  //  내가 작성한 게시물 Test
  @RequestMapping("/myboard")
  public ModelAndView myboard(HttpSession session) {
    ModelAndView mav = new ModelAndView("/login/myboardTest");



    Integer userId = (Integer) session.getAttribute("userIdx"); // Integer로 직접 가져오기

    if (userId != null) {
      List<BoardEntity> posts = boardService.findPostsByUserId(userId);
      List<ReplyEntity> comments = replyService.findRepliesByUserId(userId);
      List<ReviewEntity> reviews = reviewService.findReviewsByUserId(userId);

      mav.addObject("posts", posts);
      mav.addObject("comments", comments);
      mav.addObject("reviews", reviews);
    }
    return mav;

  }
}
