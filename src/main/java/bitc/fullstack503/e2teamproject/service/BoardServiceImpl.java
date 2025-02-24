package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import bitc.fullstack503.e2teamproject.entity.UserEntity;
import bitc.fullstack503.e2teamproject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {
  @Autowired
  private BoardRepository boardRepository;


  //  공지 쓰기
  @Override
  public void writeNotice(int userIdx, String noticeTitle, String noticeContents) {
    boardRepository.queryWriteNotice(userIdx, noticeTitle, noticeContents);
  }

  //  공지 읽기
  @Override
  public Page<BoardEntity> findNotice(int page) {
    List<Sort.Order> sorts = new ArrayList<>();
    sorts.add(Sort.Order.desc("board_idx"));
    Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
    return boardRepository.queryFindNotice(pageable);
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
  public Page<BoardEntity> findEvent(int page) {
    List<Sort.Order> sorts = new ArrayList<>();
    sorts.add(Sort.Order.desc("board_idx"));
    Pageable pageable = PageRequest.of(page,10,Sort.by(sorts));
    return boardRepository.queryFindEvent(pageable);
  }

  //  이벤트 네개씩만 보기
  @Override
  public List<BoardEntity> findEventFour() {
    Pageable eventFour = PageRequest.of(0, 4);
    return boardRepository.queryFindEventFour(eventFour);
  }

  //  이벤트 쓰기
  @Override
  public void writeEvent(int userIdx, String eventTitleCreate, String eventContentsCreate) {
    boardRepository.queryWriteEvent(userIdx, eventTitleCreate, eventContentsCreate);
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
  public Page<BoardEntity> findCrew(int page) {
    List<Sort.Order> sorts = new ArrayList<>();
    sorts.add(Sort.Order.desc("board_idx"));
    Pageable pageable = PageRequest.of(page,10,Sort.by(sorts));
    return boardRepository.queryFindCrew(pageable);
  }

  //  인원 모집 쓰기
  @Override
  public void writeCrew(int userIdx, String crewTitleCreate, String trimCrewContentsCreate) {
    boardRepository.queryWriteCrew(userIdx, crewTitleCreate, trimCrewContentsCreate);
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

  // 내가 작성한 게시글
  @Override
  public Page<BoardEntity> findPostsByUserId(int userId, Pageable pageable) {
    return boardRepository.findByUserId(userId, pageable);
  }
}




