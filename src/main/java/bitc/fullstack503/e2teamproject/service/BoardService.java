package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BoardService {
  void writeNotice(@RequestParam("noticeTitle") String noticeTitle,
                   @RequestParam("noticeContents") String noticeContents);

  void updateNotice(@RequestParam("noticeTitleUpdate") String noticeTitleUpdate,
                    @RequestParam("noticeContentsUpdate") String noticeContentsUpdate,
                    @RequestParam("noticeNumber") int noticeNumber);

  List<BoardEntity> findNotice();

  List<BoardEntity> findEvent();

  List<BoardEntity> findPerson();

  void deleteNotice(@RequestParam("noticeNumberDelete") int noticeNumberDelete);
}
