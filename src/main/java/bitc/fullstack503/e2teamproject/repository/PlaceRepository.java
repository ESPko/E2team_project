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

  //  추천수가 높은 순으로
  @Query("SELECT new bitc.fullstack503.e2teamproject.DTO.PlaceDTO(p.name, COALESCE(AVG(r.star), 0), cast(count(r) as int)) " +
          "FROM PlaceEntity p LEFT JOIN p.reviewEntityList r " +
          "WHERE p.location = :selectLocation " +
          "AND p.recommendAge <= :selectAge " +
          "AND p.numberPeople <= :selectPeople " +
          "GROUP BY p.placeIdx, p.name " +
          "ORDER BY COALESCE(AVG(r.star), 0) DESC")
  List<PlaceDTO> findPlaceStarHigh(@Param("selectLocation") String selectLocation,
                                   @Param("selectAge") int selectAge,
                                   @Param("selectPeople") int selectPeople);

  //  추천수가 낮은 순으로
  @Query("SELECT new bitc.fullstack503.e2teamproject.DTO.PlaceDTO(p.name, COALESCE(AVG(r.star), 0), cast(count(r) as int)) " +
          "FROM PlaceEntity p LEFT JOIN p.reviewEntityList r " +
          "WHERE p.location = :selectLocation " +
          "AND p.recommendAge <= :selectAge " +
          "AND p.numberPeople <= :selectPeople " +
          "GROUP BY p.placeIdx, p.name " +
          "ORDER BY COALESCE(AVG(r.star), 0) asc")
  List<PlaceDTO> findPlaceStarLow(@Param("selectLocation") String selectLocation,
                                  @Param("selectAge") int selectAge,
                                  @Param("selectPeople") int selectPeople);

  //  리뷰 많은 순으로
  @Query("SELECT new bitc.fullstack503.e2teamproject.DTO.PlaceDTO(p.name, COALESCE(AVG(r.star), 0), cast(count(r) as int)) " +
          "FROM PlaceEntity p LEFT JOIN p.reviewEntityList r " +
          "WHERE p.location = :selectLocation " +
          "AND p.recommendAge <= :selectAge " +
          "AND p.numberPeople <= :selectPeople " +
          "GROUP BY p.placeIdx, p.name " +
          "ORDER BY count(r) desc")
  List<PlaceDTO> findPlaceReviewMany(@Param("selectLocation") String selectLocation,
                                     @Param("selectAge") int selectAge,
                                     @Param("selectPeople") int selectPeople);

  //  리뷰 적은 순으로
  @Query("SELECT new bitc.fullstack503.e2teamproject.DTO.PlaceDTO(p.name, COALESCE(AVG(r.star), 0), cast(count(r) as int)) " +
          "FROM PlaceEntity p LEFT JOIN p.reviewEntityList r " +
          "WHERE p.location = :selectLocation " +
          "AND p.recommendAge <= :selectAge " +
          "AND p.numberPeople <= :selectPeople " +
          "GROUP BY p.placeIdx, p.name " +
          "ORDER BY count(r) asc")
  List<PlaceDTO> findPlaceReviewLess(@Param("selectLocation") String selectLocation,
                                     @Param("selectAge") int selectAge,
                                     @Param("selectPeople") int selectPeople);

  //  상위 세 개 추천 활동 목록
//  @Query("SELECT new bitc.fullstack503.e2teamproject.DTO.PlaceDTO(p.name, COALESCE(AVG(r.star), 0)) " +
//          "FROM PlaceEntity p LEFT JOIN p.reviewEntityList r " +
//          "GROUP BY p.placeIdx, p.name " +
//          "ORDER BY COALESCE(AVG(r.star), 0) DESC")
//  List<PlaceDTO> findTopPlacesByAverageStar(Pageable pageable);

  //  해당 placeIdx 의 정보 전부 가져오기
  @Query("select p from PlaceEntity p where p.placeIdx = :placeIdx")
  List<PlaceEntity> queryFindPlace(@Param("placeIdx") int placeIdx);

}
