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

  @Query("select new bitc.fullstack503.e2teamproject.DTO.ReviewDTO (r.reviewIdx, p.name, r.comment, r.star)" +
          "from PlaceEntity as p join p.reviewEntityList as r order by r.star desc limit 3")
  List<ReviewDTO> queryFindAllReviewSortByStar();

  @Query("SELECT new bitc.fullstack503.e2teamproject.DTO.PlaceDTO(p.name, COALESCE(AVG(r.star), 0)) " +
          "FROM PlaceEntity p LEFT JOIN p.reviewEntityList r " +
          "GROUP BY p.placeIdx, p.name " +
          "ORDER BY COALESCE(AVG(r.star), 0) DESC")
  List<PlaceDTO> findTopPlacesByAverageStar(Pageable pageable);

}
