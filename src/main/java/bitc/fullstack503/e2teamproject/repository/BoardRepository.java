package bitc.fullstack503.e2teamproject.repository;


import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

  //  공지사항 쓰기
  @Modifying
  @Transactional
  @Query(value = "insert into board (board_user_idx, title, contents, category)" +
          "values (:userIdx, :noticeTitle, :noticeContents,'공지사항')", nativeQuery = true)
  void queryWriteNotice(@Param("userIdx") int userIdx,
                        @Param("noticeTitle") String noticeTitle,
                        @Param("noticeContents") String noticeContents);

  //  공지사항 찾아서 읽어오기
  @Query("select b from BoardEntity as b where b.category = '공지사항' order by b.board_idx desc")
  Page<BoardEntity> queryFindNotice(Pageable pageable);

  //  공지사항 네개씩 읽어오기
  @Query("select b from BoardEntity as b where b.category='공지사항' order by b.board_idx desc")
  List<BoardEntity> queryFindNoticeFour(Pageable pageable);

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
          "values (:userIdx, :eventTitleCreate, :eventContentsCreate,'이벤트')", nativeQuery = true)
  void queryWriteEvent(@Param("userIdx") int userIdx,
                       @Param("eventTitleCreate") String eventTitleCreate,
                       @Param("eventContentsCreate") String eventContentsCreate);

  //  이벤트 찾아서 읽어오기
  @Query("select b from BoardEntity as b where b.category = '이벤트' order by b.board_idx desc")
  Page<BoardEntity> queryFindEvent(Pageable pageable);

  //  이벤트 네개씩 읽어오기
  @Query("select b from BoardEntity as b where b.category='이벤트' order by b.board_idx desc")
  List<BoardEntity> queryFindEventFour(Pageable pageable);

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
          "values (:userIdx, :crewTitleCreate, :trimCrewContentsCreate,'인원모집')", nativeQuery = true)
  void queryWriteCrew(@Param("userIdx") int userIdx,
                      @Param("crewTitleCreate") String crewTitleCreate,
                      @Param("trimCrewContentsCreate") String trimCrewContentsCreate);

  //    인원모집 찾아서 읽어오기
  @Query("select b from BoardEntity as b where b.category = '인원모집' order by b.board_idx desc")
  Page<BoardEntity> queryFindCrew(Pageable pageable);

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

  //  내가 작성한 게시물
  @Query("SELECT b FROM BoardEntity b WHERE b.user.user_idx = :userId")
  Page<BoardEntity> findByUserId(@Param("userId") int userId, Pageable pageable);


}
