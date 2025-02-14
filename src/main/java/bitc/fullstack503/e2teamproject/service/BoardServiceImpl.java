package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import bitc.fullstack503.e2teamproject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {
  @Autowired
  private BoardRepository boardRepository;

  //  공지 쓰기
  @Override
  public void writeNotice(String noticeTitle, String noticeContents) {
    boardRepository.queryWriteNotice(noticeTitle, noticeContents);
  }

  //  공지 읽기
  @Override
  public List<BoardEntity> findNotice() {
    return boardRepository.queryFindNotice();
  }

  //  공지 네개씩만 나오게
  @Override
  public List<BoardEntity> findNoticeFour() {
    Pageable noticeFour = PageRequest.of(0, 4);
    return boardRepository.queryFindNoticeFour(noticeFour);
  }

  //  모든 글 상세보기
  @Override
  public BoardEntity findNoticeById(int boardIdx) {
    Optional<BoardEntity> optional = boardRepository.findById(boardIdx);
    if (optional.isPresent()) {
      BoardEntity board = optional.get();
      board.setHitCount(board.getHitCount() + 1);
      boardRepository.save(board);
      return board;
    } else {
      throw new NullPointerException();
    }
  }

  //  공지 수정하기
  @Override
  public void updateNotice(String noticeTitleUpdate, String noticeContentsUpdate, int noticeNumberUpddate) {
    boardRepository.queryUpdateNotice(noticeTitleUpdate, noticeContentsUpdate, noticeNumberUpddate);
  }

  //  공지 삭제하기
  @Override
  public void deleteNotice(int noticeNumberDelete) {
    boardRepository.queryDeleteNotice(noticeNumberDelete);
  }

  //  이벤트 조회하기
  @Override
  public List<BoardEntity> findEvent() {
    return boardRepository.queryFindEvent();
  }

  //  이벤트 네개씩만 보기
  @Override
  public List<BoardEntity> findEventFour() {
    Pageable eventFour = PageRequest.of(0, 4);
    return boardRepository.queryFindEventFour(eventFour);
  }

  //  이벤트 쓰기
  @Override
  public void writeEvent(String eventTitleCreate, String eventContentsCreate) {
    boardRepository.queryWriteEvent(eventTitleCreate, eventContentsCreate);
  }

  //  이벤트 수정하기
  @Override
  public void updateEvent(String eventTitleUpdate, String eventContentsUpdate, int eventNumberUpdate) {
    boardRepository.queryUpdateEvent(eventTitleUpdate, eventContentsUpdate, eventNumberUpdate);
  }

  //  이벤트 삭제하기
  @Override
  public void deleteEvent(int eventNumberDelete) {
    boardRepository.queryDeleteEvent(eventNumberDelete);
  }

  //  인원 모집 조회하기
  @Override
  public List<BoardEntity> findCrew() {
    return boardRepository.queryFindCrew();
  }

  //  인원 모집 쓰기
  @Override
  public void writeCrew(String crewTitleCreate, String crewContentsCreate) {
    boardRepository.queryWriteCrew(crewTitleCreate, crewContentsCreate);
  }

  //  인원 모집 수정하기
  @Override
  public void updateCrew(String crewTitleUpdate, String crewContentsUpdate, int crewNumberUpdate) {
    boardRepository.queryUpdateCrew(crewTitleUpdate, crewContentsUpdate, crewNumberUpdate);
  }

  //  인원 모집 삭제하기
  @Override
  public void deleteCrew(int crewNumberDelete) {
    boardRepository.queryDeleteCrew(crewNumberDelete);
  }
}




