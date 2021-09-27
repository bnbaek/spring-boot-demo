package net.openu.apidemoservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by iopenu@gmail.com on 2021/09/24
 * Github : https://github.com/bnbaek
 */
public class BookDto {

  /**
   * GET
   */
  @ToString
  @Getter
  @Setter
  public static class GetReq {
    private String title;
    private String id;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")  // 날짜 관련 타입의 직렬화를 지원하는 어노테이션
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime requestDate;

    public GetReq(String title, String id, LocalDateTime requestDate) {
      this.title = title;
      this.id = id;
      this.requestDate = requestDate;
    }
  }

  /**
   * Post 는 DateTimeFormat  or JsonFormat 둘다 사용가능
   * 두 어노테이션 모두가 있으면 @JsonFormat이 진행된다
   *
   * @JsonFormat이 틀리면 @DateTimeFormat이 맞더라도 직렬화는 실패한다
   * 단, @DateTimeFormat이 있다면 @DateTimeFormat의 포맷으로 직렬화가 진행된다.
   */
  @ToString
  @Getter
  @Setter
  public static class PostReq {
    private String title;
    private String id;
    //    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")  // 날짜 관련 타입의 직렬화를 지원하는 어노테이션
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime requestDate;

    public PostReq(String title, String id, LocalDateTime requestDate) {
      this.title = title;
      this.id = id;
      this.requestDate = requestDate;
    }
  }

  @Getter
  public static class Res {
    private String title;
    private String id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime requestDate;

    public Res(String title, String id, LocalDateTime requestDate) {
      this.title = title;
      this.id = id;
      this.requestDate = requestDate;
    }
  }
}
