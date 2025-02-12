package bitc.fullstack503.e2teamproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "board_image")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardImageEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int board_image_idx;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "board_idx")
  @ToString.Exclude
  @JsonIgnore
  private BoardEntity board;

  private String image_original_name;

  private String image_stored_name;

  private String image_path;
}
