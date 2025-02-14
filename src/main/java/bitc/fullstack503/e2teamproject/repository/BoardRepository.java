package bitc.fullstack503.e2teamproject.repository;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> ab577824c1aa32078ca1f1f5d21424472fc593c0
import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

  //  공지사항 쓰기
  @Modifying
  @Transactional
  @Query(value = "insert into board (board_user_idx, title, contents, category)" +
          "values (1, :noticeTitle, :noticeContents,'공지사항')", nativeQuery = true)
  void queryWriteNotice(@Param("noticeTitle") String noticeTitle, @Param("noticeContents") String noticeContents);

  //  공지사항 찾아서 읽어오기
  @Query("select b from BoardEntity as b where b.category = '공지사항'")
  List<BoardEntity> queryFindNotice();

  //  공지사항 수정하기
  @Modifying
  @Transactional
  @Query("update BoardEntity b set b.title = :noticeTitleUpdate," +
          "b.contents = :noticeContentsUpdate where b.board_idx = :noticeNumberUpdate")
  void queryUpdateNotice(@Param("noticeTitleUpdate") String noticeTitleUpdate,
                         @Param("noticeContentsUpdate") String noticeContentsUpdate,
                         @Param("noticeNumberUpdate") int noticeNumberUpdate);

  //  공지사항 삭제하기
  @Modifying
  @Transactional
  @Query("delete from BoardEntity b where b.board_idx = :noticeNumberDelete")
  void queryDeleteNotice(@Param("noticeNumberDelete") int noticeNumberDelete);

  //  이벤트 쓰기
  @Modifying
  @Transactional
  @Query(value = "insert into board (board_user_idx, title, contents, category)" +
          "values (1, :eventTitleCreate, :eventContentsCreate,'이벤트')", nativeQuery = true)
  void queryWriteEvent(@Param("eventTitleCreate") String eventTitleCreate,
                       @Param("eventContentsCreate") String eventContentsCreate);

  //  이벤트 찾아서 읽어오기
  @Query("select b from BoardEntity as b where b.category = '이벤트'")
  List<BoardEntity> queryFindEvent();

  //  이벤트 수정하기
  @Modifying
  @Transactional
  @Query("update BoardEntity b set b.title = :eventTitleUpdate," +
          "b.contents = :eventContentsUpdate where b.board_idx = :eventNumberUpdate")
  void queryUpdateEvent(@Param("eventTitleUpdate") String eventTitleUpdate,
                         @Param("eventContentsUpdate") String eventContentsUpdate,
                         @Param("eventNumberUpdate") int eventNumberUpdate);

  //  이벤트 삭제하기
  @Modifying
  @Transactional
  @Query("delete from BoardEntity b where b.board_idx = :eventNumberDelete")
  void queryDeleteEvent(@Param("eventNumberDelete") int eventNumberDelete);

  //  인원모집 쓰기
  @Modifying
  @Transactional
  @Query(value = "insert into board (board_user_idx, title, contents, category)" +
          "values (2, :crewTitleCreate, :crewContentsCreate,'인원모집')", nativeQuery = true)
  void queryWriteCrew(@Param("crewTitleCreate") String crewTitleCreate,
                       @Param("crewContentsCreate") String crewContentsCreate);

  //  인원모집 찾아서 읽어오기
  @Query("select b from BoardEntity as b where b.category = '인원모집'")
<<<<<<< HEAD
  List<BoardEntity> queryFindPerson();
  //  인원모집 수정하기
  //  인원모집 삭제하기
<<<<<<< HEAD
=======
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    @Query("SELECT b FROM BoardEntity b ORDER BY b.board_idx DESC")
    List<BoardEntity> findAllByOrderByBoard_idxDesc();
>>>>>>> 945e405062063ba14e54436d47b23d687340b012
=======

  @Query("SELECT b FROM BoardEntity b ORDER BY b.board_idx DESC")
  List<BoardEntity> findAllByOrderByBoard_idxDesc();
>>>>>>> ab577824c1aa32078ca1f1f5d21424472fc593c0
=======
  List<BoardEntity> queryFindCrew();
>>>>>>> simJiHyun

  //  인원모집 수정하기
  @Modifying
  @Transactional
  @Query("update BoardEntity b set b.title = :crewTitleUpdate," +
          "b.contents = :crewContentsUpdate where b.board_idx = :crewNumberUpdate")
  void queryUpdateCrew(@Param("crewTitleUpdate") String crewTitleUpdate,
                        @Param("crewContentsUpdate") String crewContentsUpdate,
                        @Param("crewNumberUpdate") int crewNumberUpdate);

  //  인원모집 삭제하기
  @Modifying
  @Transactional
  @Query("delete from BoardEntity b where b.board_idx = :crewNumberDelete")
  void queryDeleteCrew(@Param("crewNumberDelete") int crewNumberDelete);
}
