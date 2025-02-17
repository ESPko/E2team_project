package bitc.fullstack503.e2teamproject.repository;

import bitc.fullstack503.e2teamproject.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {

//    내가 작성한 댓글
    @Query("SELECT r FROM ReplyEntity r WHERE r.userReply.user_idx = :userId")
    List<ReplyEntity> findRepliesByUserId(@Param("userId") int userId);

}
