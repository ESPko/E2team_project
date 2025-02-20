package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.ReplyEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ReplyService {
  //  댓글 보기
  List<ReplyEntity> replyShow(int crewBoardIdx);

  //  댓글 쓰기
  void replyWrite(@RequestParam("replyBoardIdx") int replyBoardIdx,
                  @RequestParam("replyUserIdx") int replyUserIdx,
                  @RequestParam("replyWriteComment") String replyWriteComment);

  //  댓글 삭제
  void replyDelete(@RequestParam("replyIdx") int replyIdx);

  //    내가 작성한 댓글
  List<ReplyEntity> findRepliesByUserId(int userId);
}
