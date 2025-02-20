package bitc.fullstack503.e2teamproject.repository;

import bitc.fullstack503.e2teamproject.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {

  //  댓글 보기
  @Query("select r from ReplyEntity r where r.boardReply.board_idx = :crewBoardIdx order by r.reply_idx desc")
  List<ReplyEntity> replyShow(@RequestParam("crewBoardIdx") int crewBoardIdx);

  //  댓글 쓰기
  @Modifying
  @Transactional
  @Query(value = "insert into reply (reply_board_idx, reply_user_idx, comment)" +
          "values (:replyBoardIdx, :replyUserIdx, :replyWriteComment)", nativeQuery = true)
  void replyWrite(@RequestParam("replyBoardIdx") int replyBoardIdx,
                  @RequestParam("replyUserIdx") int replyUserIdx,
                  @RequestParam("replyWriteComment") String replyWriteComment);

  //  댓글 삭제
  @Modifying
  @Transactional
  @Query("delete from ReplyEntity where reply_idx = :replyIdx")
  void replyDelete(@RequestParam("replyIdx") int replyIdx);

  //    내가 작성한 댓글
  @Query("SELECT r FROM ReplyEntity r WHERE r.userReply.user_idx = :userId")
  List<ReplyEntity> findRepliesByUserId(@Param("userId") int userId);
}

