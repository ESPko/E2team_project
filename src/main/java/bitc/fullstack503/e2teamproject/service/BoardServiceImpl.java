package bitc.fullstack503.e2teamproject.service;

<<<<<<< HEAD

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
=======
>>>>>>> 76f865e63340db06a4e01bb474157331518fc843
import bitc.fullstack503.e2teamproject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<BoardEntity> selectBoardList() {
        return boardRepository.findAllByOrderByBoard_idxDesc();
    }

    //    게시물 상세 보기
    @Override
    public BoardEntity selectboardDetail(int board_idx) {

        Optional<BoardEntity> optBoard = boardRepository.findById(board_idx);

        if (optBoard.isPresent()) {

            BoardEntity board = optBoard.get();

            board.setHit_count(board.getHit_count() + 1);
            boardRepository.save(board);

            return board;
        }
        else {
            throw new NullPointerException();
        }
    }



=======
@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardRepository boardRepository;
>>>>>>> 76f865e63340db06a4e01bb474157331518fc843
}
