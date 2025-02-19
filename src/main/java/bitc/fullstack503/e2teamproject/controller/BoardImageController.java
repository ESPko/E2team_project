package bitc.fullstack503.e2teamproject.controller;

import bitc.fullstack503.e2teamproject.service.BoardImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import static jakarta.persistence.GenerationType.UUID;

@RestController
@Controller
@RequestMapping("/boardImage")
public class BoardImageController {

  @Value("${file.dir}")
  private String fileDirection;

  @Autowired
  private BoardImageService boardImageService;

  @RequestMapping("/")
  public String boardImage() {
    return "boardImage";
  }

  //  실험용
  @ResponseBody
  @PostMapping("/image-upload")
  public String uploadEditorImage(@RequestParam final MultipartFile image) {
    if (image.isEmpty()) {
      return "";
    }
    String orgFilename = image.getOriginalFilename();                                         // 원본 파일명
    String uuid = java.util.UUID.randomUUID().toString().replaceAll("-", "");          // 32자리 랜덤 문자열
    String extension = orgFilename.substring(orgFilename.lastIndexOf(".") + 1);  // 확장자
    String saveFilename = uuid + "." + extension;                                             // 디스크에 저장할 파일명
    String fileFullPath = Paths.get(fileDirection, saveFilename).toString();

    System.out.println("원본 파일 이름 : " + orgFilename);
    System.out.println("uuid : " + uuid);
    System.out.println("저장된 파일이름 : " + saveFilename);
    System.out.println("파일 경로 : " + fileFullPath);

    File dir = new File(fileDirection);
    if (!dir.exists()) {
      dir.mkdirs();
    }

    try {
      // 파일 저장 (write to disk)
      File uploadFile = new File(fileFullPath);
      image.transferTo(uploadFile);
      return saveFilename;

    } catch (IOException e) {
      // 예외 처리는 따로 해주는 게 좋습니다.
      throw new RuntimeException(e);
    }
  }

  /**
   * 디스크에 업로드된 파일을 byte[]로 반환
   * @param filename 디스크에 업로드된 파일명
   * @return image byte array
   */
  @ResponseBody
  @GetMapping(value = "/image-print", produces = { MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
  public byte[] printEditorImage(@RequestParam final String filename) {
    // 업로드된 파일의 전체 경로
    String fileFullPath = Paths.get(fileDirection, filename).toString();

    // 파일이 없는 경우 예외 throw
    File uploadedFile = new File(fileFullPath);
    if (!uploadedFile.exists()) {
      throw new RuntimeException();
    }

    try {
      // 이미지 파일을 byte[]로 변환 후 반환
      return Files.readAllBytes(uploadedFile.toPath());

    } catch (IOException e) {
      // 예외 처리는 따로 해주는 게 좋습니다.
      throw new RuntimeException(e);
    }
  }
}
