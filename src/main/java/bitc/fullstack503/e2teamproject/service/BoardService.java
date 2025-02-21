package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import bitc.fullstack503.e2teamproject.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

public interface BoardService {
  //  공지 읽기
  Page<BoardEntity> findNotice(int page);

  //  공지 네개씩만 나오게
  List<BoardEntity> findNoticeFour();

  //  공지 상세보기
  BoardEntity findNoticeById(@RequestParam("boardIdx") int boardIdx);

  //  공지 쓰기
  void writeNotice(@RequestParam("userIdx") int userIdx,
                   @RequestParam("noticeTitle") String noticeTitle,
                   @RequestParam("noticeContents") String noticeContents);

  //  공지 수정하기
  void updateNotice(@RequestParam("noticeTitleUpdate") String noticeTitleUpdate,
                    @RequestParam("noticeContentsUpdate") String noticeContentsUpdate,
                    @RequestParam("noticeNumberUpdate") int noticeNumberUpdate);

  //  공지 삭제하기
  void deleteNotice(@RequestParam("noticeNumberDelete") int noticeNumberDelete);

  //  이벤트 조회하기
  Page<BoardEntity> findEvent(int page);

  //  이벤트 네개씩만 보기
  List<BoardEntity> findEventFour();

  //  이벤트 쓰기
  void writeEvent(@RequestParam("userIdx") int userIdx,
                  @RequestParam("eventTitleCreate") String eventTitleCreate,
                  @RequestParam("eventContentsCreate") String eventContentsCreate);

  //  이벤트 수정하기
  void updateEvent(@RequestParam("eventTitleUpdate") String eventTitleUpdate,
                   @RequestParam("eventContentsUpdate") String eventContentsUpdate,
                   @RequestParam("eventNumberUpdate") int eventNumberUpdate);

  //  이벤트 삭제하기
  void deleteEvent(@RequestParam("eventNumberDelete") int eventNumberDelete);

  //  인원 모집 조회하기
  Page<BoardEntity> findCrew(int page);

  //  인원 모집 쓰기
  void writeCrew(@RequestParam("userIdx") int userIdx,
                 @RequestParam("crewTitleCreate") String crewTitleCreate,
                 @RequestParam("trimCrewContentsCreate") String trimCrewContentsCreate);

  //  인원 모집 수정하기
  void updateCrew(@RequestParam("crewTitleUpdate") String crewTitleUpdate,
                  @RequestParam("crewContentsUpdate") String crewContentsUpdate,
                  @RequestParam("crewNumberUpdate") int crewNumberUpdate);

  //  인원모집 삭제하기
  void deleteCrew(@RequestParam("crewNumberDelete") int crewNumberDelete);

  //  내가 작성한 게시글
  Page<BoardEntity> findPostsByUserId(int userId, Pageable pageable);
}
