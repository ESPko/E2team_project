package bitc.fullstack503.e2teamproject.repository;

import bitc.fullstack503.e2teamproject.DTO.PlaceDTO;
import bitc.fullstack503.e2teamproject.DTO.ReviewDTO;
import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity, Integer> {

  //  place_idx 를 기준으로 오름차순
  @Query("select p from PlaceEntity p where p.location = :selectLocation " +
          "and p.recommendAge <= :selectAge and p.numberPeople<= :selectPeople order by p.placeIdx")
  List<PlaceEntity> findByLocation(@Param("selectLocation") String selectLocation,
                                   @Param("selectAge") int selectAge,
                                   @Param("selectPeople") int selectPeople);

  //  해당 placeIdx 의 정보 전부 가져오기
  @Query("select p from PlaceEntity p where p.placeIdx = :placeIdx")
  List<PlaceEntity> queryFindPlace(@Param("placeIdx") int placeIdx);

  //  공방 카테고리 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '공방' LIMIT 1", nativeQuery = true)
  PlaceEntity queryFindCategoryGold();

  //  댄스학원 카테고리 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '댄스학원' LIMIT 1", nativeQuery = true)
  PlaceEntity queryFindCategoryDance();

  //  도서관 카테고리 가져오기
  @Query(value = "select * from place where category='도서관' limit 1", nativeQuery = true)
  PlaceEntity queryFindCategoryLibrary();

  //  동물카페
  @Query(value = "select * from place where category='동물카페' limit 1", nativeQuery = true)
  PlaceEntity queryFindCategoryAnimal();

  //  루지
  @Query(value = "select * from place where category='루지' limit 1", nativeQuery = true)
  PlaceEntity queryFindCategoryLoogi();

  //  멀티방
  @Query(value = "select * from place where category='멀티방' limit 1", nativeQuery = true)
  PlaceEntity queryFindCategoryMulti();

  //  메이드집사
  @Query(value = "select * from place where category='메이드집사' limit 1", nativeQuery = true)
  PlaceEntity queryFindCategoryMaid();

  //  무인스튜디오
  @Query(value = "select * from place where category='무인스튜디오' limit 1", nativeQuery = true)
  PlaceEntity queryFindCategorySelfStudio();

  //  방탈출
  @Query(value = "select * from place where category='방탈출' limit 1", nativeQuery = true)
  PlaceEntity queryFindCategoryEscapeRoom();

  //  베이킹
  @Query(value = "select * from place where category='베이킹체험' limit 1", nativeQuery = true)
  PlaceEntity queryFindCategoryBaking();

  //  보드게임 하나
  @Query(value = "select * from place where category='보드게임' limit 1", nativeQuery = true)
  PlaceEntity queryFindCategoryBoard();

  //  보드게임 전부 가져오기
  @Query(value = "select * from place where category = '보드게임'", nativeQuery = true)
  List<PlaceEntity> queryFindBoardList();

  //  볼링장 카테고리 하나 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '볼링장' LIMIT 1", nativeQuery = true)
  PlaceEntity queryFindCategoryBalling();

  //  볼링장 카테고리 전부 가져오기
  @Query(value = "Select * from place where category = '볼링장'", nativeQuery = true)
  List<PlaceEntity> queryFindBallingList();

  //  서바이벌 카테고리 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '서바이벌' LIMIT 1", nativeQuery = true)
  PlaceEntity queryFindCategorySurvival();

  //  서핑 카테고리 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '서핑'", nativeQuery = true)
  PlaceEntity queryFindCategorySurfing();

  //  스카이다이빙
  @Query(value = "select * from place where category='스카이다이빙'", nativeQuery = true)
  PlaceEntity queryFindCategorySkyDiving();

  //  슬라임카페 카테고리 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '슬라임카페' LIMIT 1", nativeQuery = true)
  PlaceEntity queryFindCategorySlime();

  //  실내사격 카테고리 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '실내사격' LIMIT 1", nativeQuery = true)
  PlaceEntity queryFindCategoryShooting();

  //  짚라인 카테고리 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '짚라인' LIMIT 1", nativeQuery = true)
  PlaceEntity queryFindCategoryZipLine();

  //  카트체험 카테고리 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '카트장'", nativeQuery = true)
  PlaceEntity queryFindCategoryCart();

  //  컨벤션 카테고리 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '컨벤션'", nativeQuery = true)
  PlaceEntity queryFindCategoryConvention();

  //  코인노래방 카테고리 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '코인노래방' LIMIT 1", nativeQuery = true)
  PlaceEntity queryFindCategoryCoinSing();

  //  클라이밍 카테고리 하나 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '클라이밍' LIMIT 1", nativeQuery = true)
  PlaceEntity queryFindCategoryClimbing();

  //  클라이밍 카테고리 전부 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '클라이밍'", nativeQuery = true)
  List<PlaceEntity> queryFindClimbingList();

  //  키자니아 카테고리 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '키자니아' LIMIT 1", nativeQuery = true)
  PlaceEntity queryFindCategoryKizania();

  //  키즈카페
  @Query(value = "select * from place where category='키즈카페' limit 1", nativeQuery = true)
  PlaceEntity queryFindCategoryKidsCafe();

  //  테마파크 카테고리 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '테마파크' LIMIT 1", nativeQuery = true)
  PlaceEntity queryFindCategoryThemePark();

  //  틱톡
  @Query(value = "select * from place where category='틱톡부스'", nativeQuery = true)
  PlaceEntity queryFindCategoryTikTok();

  //  파티룸 카테고리 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '파티룸' LIMIT 1", nativeQuery = true)
  PlaceEntity queryFindCategoryPartyRoom();

  //  페러세일
  @Query(value = "select * from place where category = '패러세일링'", nativeQuery = true)
  PlaceEntity queryFindCategoryParasail();

  //  홀덤펍 카테고리 가져오기
  @Query(value = "SELECT * FROM place WHERE category = '홀덤펍' LIMIT 1", nativeQuery = true)
  PlaceEntity queryFindCategoryHoldum();
}
