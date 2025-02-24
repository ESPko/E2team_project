package bitc.fullstack503.e2teamproject.DTO;

import bitc.fullstack503.e2teamproject.entity.ReplyEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
  private int replyIdx;
  private String userId;
  private String userName;
  private String comment;
  private LocalDateTime createDate;

  public static ReplyDTO fromEntity(ReplyEntity reply) {
    return new ReplyDTO(
            reply.getReply_idx(),
            reply.getUserReply().getId(), // 여기서 UserEntity의 id 값 가져옴
            reply.getUserReply().getName(),
            reply.getComment(),
            reply.getCreateDate()
    );
  }
}
