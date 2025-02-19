package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.BoardEntity;
import org.springframework.web.multipart.MultipartFile;

public interface BoardImageService {
  //  첨부파일 여러개 등록
  void saveFiles(MultipartFile[] files, BoardEntity board);
}
