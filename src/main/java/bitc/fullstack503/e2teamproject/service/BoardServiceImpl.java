package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
<<<<<<< HEAD
=======


>>>>>>> 945e405062063ba14e54436d47b23d687340b012
import bitc.fullstack503.e2teamproject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> 945e405062063ba14e54436d47b23d687340b012

@Service
public class BoardServiceImpl implements BoardService {

<<<<<<< HEAD
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

=======
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<BoardEntity> selectBoardList() {
        return boardRepository.findAllByOrderByBoard_idxDesc();
    }

    //    게시물 상세 보기
    @Override
    public BoardEntity selectboardDetail(int board_idx) {

        Optional<BoardEntity> optBoard = boardRepository.findById(board_idx);

        if (optBoard.isPresent()) {

            BoardEntity board = optBoard.get();

            board.setHitCount(board.getHitCount() + 1);
            boardRepository.save(board);

            return board;
        } else {
            throw new NullPointerException();
        }
    }
>>>>>>> 945e405062063ba14e54436d47b23d687340b012

}




