package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BoardService {

  //  공지 읽기
  List<BoardEntity> findNotice();

  //  공지 쓰기
  void writeNotice(@RequestParam("noticeTitle") String noticeTitle,
                   @RequestParam("noticeContents") String noticeContents);

  //  공지 수정하기
  void updateNotice(@RequestParam("noticeTitleUpdate") String noticeTitleUpdate,
                    @RequestParam("noticeContentsUpdate") String noticeContentsUpdate,
                    @RequestParam("noticeNumber") int noticeNumber);

  //  공지 삭제하기
  void deleteNotice(@RequestParam("noticeNumberDelete") int noticeNumberDelete);

  //  이벤트 읽기
  List<BoardEntity> findEvent();

  //  이벤트 쓰기
  void writeEvent(@RequestParam("eventTitleCreate") String eventTitleCreate,
                  @RequestParam("eventContentsCreate") String eventContentsCreate);

  //  이벤트 수정하기
  void updateEvent(@RequestParam("eventTitleUpdate") String eventTitleUpdate,
                   @RequestParam("eventContentsUpdate") String eventContentsUpdate,
                   @RequestParam("eventNumberUpdate") int eventNumberUpdate);

  //  이벤트 삭제하기
  void deleteEvent(@RequestParam("eventNumberDelete") int eventNumberDelete);

  //  인원 모집 읽기
  List<BoardEntity> findPerson();


}
