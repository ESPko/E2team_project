package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
=======
>>>>>>> 945e405062063ba14e54436d47b23d687340b012

import java.util.List;

public interface BoardService {
<<<<<<< HEAD
  void writeNotice(@RequestParam("noticeTitle") String noticeTitle,
                   @RequestParam("noticeContents") String noticeContents);

  void updateNotice(@RequestParam("noticeTitleUpdate") String noticeTitleUpdate,
                    @RequestParam("noticeContentsUpdate") String noticeContentsUpdate,
                    @RequestParam("noticeNumber") int noticeNumber);

  List<BoardEntity> findNotice();

  List<BoardEntity> findEvent();

  List<BoardEntity> findPerson();

  void deleteNotice(@RequestParam("noticeNumberDelete") int noticeNumberDelete);
=======

    List<BoardEntity> selectBoardList();

    BoardEntity selectboardDetail(int board_idx);
>>>>>>> 945e405062063ba14e54436d47b23d687340b012
}
