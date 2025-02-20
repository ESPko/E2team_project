package bitc.fullstack503.e2teamproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "review")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReviewEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int reviewIdx;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "review_place_idx")
  @ToString.Exclude
  private PlaceEntity placeReview;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "review_user_idx")
  @ToString.Exclude
  private UserEntity userReview;

  private String comment;

  private double star;

  @Column(name = "write_date")
  private LocalDateTime writeDate;

  @Column(name = "hit_count")
  private int hitCount = 0;

  @Column(name = "like_count")
  private int likeCount = 0;

  @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @ToString.Exclude
  @Builder.Default
  private List<ReviewImageEntity> reviewImageEntityList = new ArrayList<>();
}
