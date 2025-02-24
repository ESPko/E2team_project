package bitc.fullstack503.e2teamproject.entity;

import jakarta.persistence.*;
import jakarta.websocket.OnError;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "place")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlaceEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int placeIdx;

  private String location;

  private String address;

  private String name;

  @Column(name = "recommend_age")
  private String recommendAge;

  @Column(name = "number_people")
  private int numberPeople;

  @Column(name = "open_time")
  private String openTime;

  @Column(name = "close_time")
  private String closeTime;

  private String phone;

  private String category;

  @Transient
  private double averageStar;

  @Transient
  private int reviewCount;

  @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @ToString.Exclude
  @Builder.Default
  private List<PlaceImageEntity> placeImageEntityList = new ArrayList<>();

  @OneToMany(mappedBy = "placeReview", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @ToString.Exclude
  @Builder.Default
  private List<ReviewEntity> reviewEntityList = new ArrayList<>();
}
