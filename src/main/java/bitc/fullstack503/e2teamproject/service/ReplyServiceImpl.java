package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.ReplyEntity;
import bitc.fullstack503.e2teamproject.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

  @Autowired
  private ReplyRepository replyRepository;

  //  댓글 보기
  @Override
  public List<ReplyEntity> replyShow(int crewBoardIdx) {
    return replyRepository.replyShow(crewBoardIdx);
  }

  //  댓글 쓰기
  @Override
  public void replyWrite(int crewBoardIdx, String replyWriteComment) {
    replyRepository.replyWrite(crewBoardIdx, replyWriteComment);
  }

//  댓글 수정

  //  댓글 삭제
  @Override
  public void replyDelete(int replyIdx) {
    replyRepository.replyDelete(replyIdx);
  }
}
