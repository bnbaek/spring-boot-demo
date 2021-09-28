package net.openu.apidemoservice.dto.api;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.openu.apidemoservice.dto.BookDto;
import net.openu.apidemoservice.redis.entity.Point;
import net.openu.apidemoservice.redis.repository.PointRedisRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by iopenu@gmail.com on 2021/09/24
 * Github : https://github.com/bnbaek
 */
@Slf4j
@RequiredArgsConstructor

@RestController
public class BookController {

  private final PointRedisRepository pointRedisRepository;

  /**
   * Request Parameter
   *
   * @param req
   * @return
   * @ModelAttribute로 DTO 객체를 받는다.
   * @RequestParamter로 필드별로 받는다.
   */
  @GetMapping("/api/book")
  public String getTest(BookDto.GetReq req) {

    log.info("Get Data {}", req);
    return "GET";
  }

  @GetMapping("/api/book/requestParam")
  public String getTestRequestParam(@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                                    @RequestParam("requestDate") LocalDateTime requestDate) {
    //given
    String id = "jojoldu";
    LocalDateTime refreshTime = LocalDateTime.of(2018, 5, 26, 0, 0);
    Point point = Point.builder()
        .id(id)
        .amount(1000L)
        .refreshTime(refreshTime)
        .build();

    //when
    pointRedisRepository.save(point);
    log.info("Get Data requestParam {}", requestDate);
    return "GET";
  }

  @PostMapping("/api/book")
  public String postTest(@RequestBody BookDto.PostReq req) {
    log.info("POST Data {}", req);
    return "POST";
  }

  @GetMapping("/api/book/response")
  public BookDto.Res response() {
    Point getPoint = pointRedisRepository.findById("jojoldu").orElse(null);
    log.info("getePoint {}",getPoint);
    return new BookDto.Res("resTitle", "resId", LocalDateTime.of(2021, 9, 24, 11, 12, 23));
  }
}
