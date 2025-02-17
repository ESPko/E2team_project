package bitc.fullstack503.e2teamproject.service;

import bitc.fullstack503.e2teamproject.entity.BoardImageEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardImageService {
  //  첨부파일 여러개 등록
  List<BoardImageEntity> saveFiles(MultipartFile[] files);
}
