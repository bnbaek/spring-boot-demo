package net.openu.apidemoservice.redis.repository;

//import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import net.openu.apidemoservice.redis.entity.Point;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "job.name=a")
//@SpringBootTest
public class PointRedisRepositoryTest {

    @Autowired
    PointRedisRepository pointRedisRepository;


    @Test
    public void 기본_등록_조회기능() {
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

        //then
        Point savedPoint = pointRedisRepository.findById(id).get();
        assertThat(savedPoint.getAmount()).isEqualTo(1000L);
        assertThat(savedPoint.getRefreshTime()).isEqualTo(refreshTime);
    }

}