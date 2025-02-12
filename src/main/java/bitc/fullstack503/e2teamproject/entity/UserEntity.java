package bitc.fullstack503.e2teamproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int user_idx;

  private String id;

  private String password;

  private String email;

  private String phone;

  private String birth_year;

  private LocalDateTime create_date = LocalDateTime.now();

  private int level;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @ToString.Exclude
  @Builder.Default
  private List<BoardEntity> boardEntityList = new ArrayList<>();

  @OneToMany(mappedBy = "userReply", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @ToString.Exclude
  @Builder.Default
  private List<ReplyEntity> replyEntityList = new ArrayList<>();

  @OneToMany(mappedBy = "userReview", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @ToString.Exclude
  @Builder.Default
  private List<ReviewEntity> reviewEntityList = new ArrayList<>();
}
