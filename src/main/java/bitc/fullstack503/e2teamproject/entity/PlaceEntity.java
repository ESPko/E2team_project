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
  private int place_idx;

  private String location;

  private String address;

  private String name;

  private String recommend_age;

  private int number_people;

  private String open_time;

  private String close_time;

  private String phone;

  private String introduce;

  private String money;

  @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @ToString.Exclude
  @Builder.Default
  private List<PlaceImageEntity> placeImageEntityList = new ArrayList<>();

  @OneToMany(mappedBy = "placeReview", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @ToString.Exclude
  @Builder.Default
  private List<ReviewEntity> reviewEntityList = new ArrayList<>();
}
