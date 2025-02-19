package bitc.fullstack503.e2teamproject.repository;

import bitc.fullstack503.e2teamproject.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {

  //  댓글 쓰기
  @Modifying
  @Transactional
  @Query(value = "insert into reply (reply_board_idx, reply_user_idx, comment)" +
          "values (:crewBoardIdx, 2, :replyWriteComment)", nativeQuery = true)
  void writeReply(@RequestParam("crewBoardIdx") int crewBoardIdx,
                  @RequestParam("replyWriteComment") String replyWriteComment);
}
