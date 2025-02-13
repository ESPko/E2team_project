package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;

import java.util.List;

public interface BoardService {

    List<BoardEntity> selectBoardList();

    BoardEntity selectboardDetail(int board_idx);
}
