package bitc.fullstack503.e2teamproject.repository;

import bitc.fullstack503.e2teamproject.DTO.PlaceDTO;
import bitc.fullstack503.e2teamproject.DTO.ReviewDTO;
import bitc.fullstack503.e2teamproject.entity.PlaceEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity, Integer> {
//  상위 세 개 추천 활동 목록
  @Query("SELECT new bitc.fullstack503.e2teamproject.DTO.PlaceDTO(p.name, COALESCE(AVG(r.star), 0)) " +
          "FROM PlaceEntity p LEFT JOIN p.reviewEntityList r " +
          "GROUP BY p.placeIdx, p.name " +
          "ORDER BY COALESCE(AVG(r.star), 0) DESC")
  List<PlaceDTO> findTopPlacesByAverageStar(Pageable pageable);

}
