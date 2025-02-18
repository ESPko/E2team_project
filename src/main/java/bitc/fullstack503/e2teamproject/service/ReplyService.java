package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.ReplyEntity;

import java.util.List;

public interface ReplyService {

//    내가 작성한 댓글
    List<ReplyEntity> findRepliesByUserId(int userId);

}
