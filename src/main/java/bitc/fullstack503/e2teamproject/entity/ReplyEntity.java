package bitc.fullstack503.e2teamproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reply")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReplyEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int reply_idx;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reply_board_idx")
  @ToString.Exclude
  @JsonIgnore
  private BoardEntity boardReply;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reply_user_idx")
  @ToString.Exclude
  @JsonIgnore
  private UserEntity userReply;

  @Column(name = "reply_user_name")
  private String replyUserName;

  private String comment;

  @Column(name = "create_date")
  private LocalDateTime createDate;

}
