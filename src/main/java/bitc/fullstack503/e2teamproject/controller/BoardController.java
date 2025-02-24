package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.entity.*;
import bitc.fullstack503.e2teamproject.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Controller
public class BoardController {

  @Autowired
  private BoardService boardService;

  @Autowired
  private ReplyService replyService;

  @Autowired
  private ReviewService reviewService;

  @Autowired
  private UserService userService;

  @Autowired
  private PlaceService placeService;

  // 프로필
  @RequestMapping("/pro")
  public ModelAndView profile(HttpServletRequest request) {

    HttpSession session = request.getSession();
    String userId = (String) session.getAttribute("userId");

    ModelAndView mav = new ModelAndView("/login/profilePage");

    if (userId == null) {
      mav.setViewName("redirect:/user/?errMsg=로그인이 필요합니다.");
      return mav;
    }

    UserEntity user = userService.getUserInfo(userId);
    mav.addObject("user", user);
    return mav;
  }

  // 회원가입 페이지
  @RequestMapping("/regist")
  public ModelAndView regist() {
    return new ModelAndView("/login/registerPage");
  }

  //  메인 페이지
  @RequestMapping("/")
  public ModelAndView home() {
    ModelAndView mav = new ModelAndView("/board/mainPage");
//    위에 하나만
    PlaceEntity findBallingList = placeService.findPlaceBalling();
    PlaceEntity findClimbingList = placeService.findPlaceClimbing();
    PlaceEntity findBoardList = placeService.findPlaceBoard();

//    전부
    List<PlaceEntity> findBallingAll = placeService.findPlaceBallingList();
    List<PlaceEntity> findClimbingAll = placeService.findPlaceClimbingList();
    List<PlaceEntity> findBoardAll = placeService.findPlaceBoardList();

    mav.addObject("findBallingList", findBallingList);
    mav.addObject("findClimbingList", findClimbingList);
    mav.addObject("findBoardList", findBoardList);

    mav.addObject("findBallingAll", findBallingAll);
    mav.addObject("findClimbingAll", findClimbingAll);
    mav.addObject("findBoardAll", findBoardAll);
    return mav;
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

  //  공지 쓰기 뷰
  @RequestMapping("/notice/write")
  public ModelAndView writeNotice() {
    return new ModelAndView("/board/noticeWritePage");
  }

  //  공지 쓰기
  @ResponseBody
  @PostMapping("/notice/write")
  public void writeNotice(@RequestParam("noticeTitle") String noticeTitle,
                          @RequestParam("noticeContents") String noticeContents,
                          HttpServletRequest request) {
    HttpSession session = request.getSession();
    Integer userIdx = (Integer) session.getAttribute("userIdx");
    boardService.writeNotice(userIdx, noticeTitle, noticeContents);
  }

  //  공지 수정 뷰
  @RequestMapping("/notice/edit/{boardIdx}")
  public ModelAndView noticeEdit(@PathVariable("boardIdx") int boardIdx) {
    ModelAndView mav = new ModelAndView("/board/noticeEditPage");
    BoardEntity notice = boardService.findNoticeById(boardIdx);
    mav.addObject("notice", notice);
    return mav;
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
  public ResponseEntity<String> deleteNotice(@RequestParam("noticeUserIdx") int noticeUserIdx,
                                             @RequestParam("noticeNumberDelete") int noticeNumberDelete,
                                             HttpServletRequest request) {
    HttpSession session = request.getSession();
    Integer sessionUserIdx = (Integer) session.getAttribute("userIdx");

    if (!sessionUserIdx.equals(noticeUserIdx)) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("관리자 외에 공지는 삭제할 수 업습니다");
    } else {
      boardService.deleteEvent(noticeNumberDelete);
      return ResponseEntity.ok("삭제 완료");
    }
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

  //  이벤트 쓰기 뷰
  @RequestMapping("/event/write")
  public ModelAndView writeEvent() {
    return new ModelAndView("/board/eventWritePage");
  }

  //  이벤트 쓰기
  @ResponseBody
  @PostMapping("/event/write")
  public void writeEvent(@RequestParam("eventTitleCreate") String eventTitleCreate,
                         @RequestParam("eventContentsCreate") String eventContentsCreate,
                         HttpServletRequest request) {
    HttpSession session = request.getSession();
    Integer userIdx = (Integer) session.getAttribute("userIdx");
    boardService.writeEvent(userIdx, eventTitleCreate, eventContentsCreate);
  }

  //  이벤트 수정 뷰
  @RequestMapping("/event/edit/{boardIdx}")
  public ModelAndView eventEdit(@PathVariable("boardIdx") int boardIdx) {
    ModelAndView mav = new ModelAndView("/board/eventEditPage");
    BoardEntity event = boardService.findNoticeById(boardIdx);
    mav.addObject("event", event);
    return mav;
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
  public ResponseEntity<String> deleteEvent(@RequestParam("eventUserIdx") int eventUserIdx,
                                            @RequestParam("eventNumberDelete") int eventNumberDelete,
                                            HttpServletRequest request) {
    HttpSession session = request.getSession();
    Integer userIdx = (Integer) session.getAttribute("userIdx");

    if (!userIdx.equals(eventUserIdx)) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("관리자 외에 이벤트는 삭제할 수 업습니다");
    } else {
      boardService.deleteEvent(eventNumberDelete);
      return ResponseEntity.ok("삭제 완료");
    }
  }

  //  인원 모집 보기
  @RequestMapping("/crew")
  public ModelAndView crewRead(@RequestParam(value = "page", defaultValue = "0") int page,
                               HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("/board/crewPage");
    Page<BoardEntity> findCrewList = boardService.findCrew(page);
    mav.addObject("findCrewList", findCrewList);
    return mav;
  }

  //  인원 모집 상세보기
  @RequestMapping("/crew/{boardIdx}")
  public ModelAndView crewReadMore(@PathVariable("boardIdx") int boardIdx,
                                   HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("/board/crewDetailPage");
    BoardEntity crew = boardService.findNoticeById(boardIdx);
    mav.addObject("crew", crew);
    return mav;
  }

  //  인원 모집 쓰기 뷰
  @GetMapping("/crew/write")
  public ModelAndView writeCrewView(HttpServletRequest request) {
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

    boardService.writeCrew(userIdx, crewTitleCreate, trimCrewContentsCreate);
  }

  //  인원 모집 수정 뷰
  @RequestMapping("/crew/edit/{boardIdx}")
  public ModelAndView crewEdit(@PathVariable("boardIdx") int boardIdx,
                               HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("/board/crewEditPage");
    BoardEntity crew = boardService.findNoticeById(boardIdx);
    mav.addObject("crew", crew);

    return mav;
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
  public ResponseEntity<String> deleteCrew(@RequestParam("crewNumberDelete") int crewNumberDelete,
                                           @RequestParam("crewUserId") String crewUserId,
                                           HttpServletRequest request) {
    HttpSession session = request.getSession();
    String userId = session.getAttribute("userId").toString();

    if (!userId.equals(crewUserId)) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("타인의 게시물은 삭제할 수 업습니다");
    } else {
      boardService.deleteCrew(crewNumberDelete);
      return ResponseEntity.ok("삭제 완료");
    }
  }


  //  내가 작성한 게시물
  @RequestMapping("/myboard")
  public ModelAndView myboard(HttpSession session,
                              @RequestParam(defaultValue = "0") int postPage,
                              @RequestParam(defaultValue = "0") int commentPage,
                              @RequestParam(defaultValue = "0") int reviewPage) {
    ModelAndView mav = new ModelAndView("login/myboard");

    Integer userId = (Integer) session.getAttribute("userIdx");

    if (userId != null) {
      Pageable postPageable = PageRequest.of(postPage, 5); // 한 페이지에 5개씩
      Pageable commentPageable = PageRequest.of(commentPage, 5);
      Pageable reviewPageable = PageRequest.of(reviewPage, 5);

      Page<BoardEntity> posts = boardService.findPostsByUserId(userId, postPageable);
      Page<ReplyEntity> comments = replyService.findRepliesByUserId(userId, commentPageable);
      Page<ReviewEntity> reviews = reviewService.findReviewsByUserId(userId, reviewPageable);

      mav.addObject("posts", posts);
      mav.addObject("comments", comments);
      mav.addObject("reviews", reviews);
    }
    return mav;
  }

}
