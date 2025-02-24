package bitc.fullstack503.e2teamproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private UserEntity userReview;

  @Column(name = "review_user_id")
  private String reviewUserId;

  @Column(name = "review_user_name")
  private String reviewUserName;

  private String comment;

  private double star;

  @Column(name = "write_date")
  private LocalDateTime writeDate;
}
