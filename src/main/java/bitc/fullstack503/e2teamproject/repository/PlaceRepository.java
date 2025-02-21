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

}
