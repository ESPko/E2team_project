package bitc.fullstack503.e2teamproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "review_image")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReviewImageEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int review_image_idx;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "review_idx")
  @ToString.Exclude
  @JsonIgnore
  private ReviewEntity review;

  private String image_original_name;

  private String image_stored_name;

  private String image_path;
}
