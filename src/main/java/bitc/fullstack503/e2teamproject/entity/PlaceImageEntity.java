package bitc.fullstack503.e2teamproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "place_image")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlaceImageEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int place_image_idx;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "place_idx")
  @ToString.Exclude
  @JsonIgnore
  private PlaceEntity place;

  private String image_original_name;

  private String image_stored_name;

  private String image_path;
}
