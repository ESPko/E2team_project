package bitc.fullstack503.e2teamproject.repository;

import bitc.fullstack503.e2teamproject.entity.PlaceImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceImageRepository extends JpaRepository<PlaceImageEntity, Integer> {
//  특정 장소에 대한 사진들만 보기
  @Query("select p from PlaceImageEntity p where p.place.placeIdx=2")
  List<PlaceImageEntity> queryFindImage();
}
