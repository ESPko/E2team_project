package bitc.fullstack503.e2teamproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int board_idx;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "board_user_idx")
  @ToString.Exclude
  @JsonIgnore
  private UserEntity user;

  private String title;

  private String contents;

  private LocalDateTime create_date;

  private LocalDateTime update_date;

  private int hit_count;

  private int like_count;

  @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @ToString.Exclude
  @Builder.Default
  private List<BoardImageEntity> boardImageEntityList = new ArrayList<>();

  @OneToMany(mappedBy = "boardReply", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @ToString.Exclude
  @Builder.Default
  private List<ReplyEntity> replyEntityList = new ArrayList<>();
}
