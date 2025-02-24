package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import bitc.fullstack503.e2teamproject.entity.ReplyEntity;
import bitc.fullstack503.e2teamproject.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

  @Autowired
  private ReplyRepository replyRepository;

//  내가 작성한 댓글
  @Override
  public Page<ReplyEntity> findRepliesByUserId(int userId, Pageable pageable) {
    return replyRepository.findRepliesByUserId(userId, pageable);
  }

  //  댓글 보기
  @Override
  public List<ReplyEntity> replyShow(int crewBoardIdx) {
    return replyRepository.replyShow(crewBoardIdx);
  }

  //  댓글 쓰기
  @Override
  public void replyWrite(int replyBoardIdx, int replyUserIdx, String replyUserName, String replyWriteComment) {
    replyRepository.replyWrite(replyBoardIdx, replyUserIdx, replyUserName, replyWriteComment);
  }

  //  댓글 삭제
  @Override
  public void replyDelete(int replyIdx) {
    replyRepository.replyDelete(replyIdx);
  }


}
