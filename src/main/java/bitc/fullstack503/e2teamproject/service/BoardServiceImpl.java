package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import bitc.fullstack503.e2teamproject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

  //  공지 수정하기
  @Override
  public void updateNotice(String noticeTitleUpdate, String noticeContentsUpdate, int noticeNumber) {
    boardRepository.queryUpdateNotice(noticeTitleUpdate, noticeContentsUpdate, noticeNumber);
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

  //  인원 모집 조회하기
  @Override
  public List<BoardEntity> findPerson() {
    return boardRepository.queryFindPerson();
  }


}
