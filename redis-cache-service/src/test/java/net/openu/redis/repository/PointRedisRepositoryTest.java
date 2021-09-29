package net.openu.redis.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import net.openu.redis.EmbeddedRedisConfig;
 import net.openu.redis.entity.Point;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {EmbeddedRedisConfig.class})
@EnableAutoConfiguration
@TestPropertySource(properties = "job.name=a")
public class PointRedisRepositoryTest {

    @Autowired
    PointRedisRepository pointRedisRepository;

    @Test
    public void 등록_조회() {

        //given
        String id = "bbn";
        LocalDateTime refreshTime = LocalDateTime.of(2018, 5, 26, 0, 0);
        Point point = Point.builder()
            .id(id)
            .amount(1000L)
            .refreshTime(refreshTime)
            .build();
        //when
        Point save = pointRedisRepository.save(point);
        System.out.println(save);
        Point savedPoint = pointRedisRepository.findById(id).get();
        assertThat(savedPoint.getAmount()).isEqualTo(1000L);
        assertThat(savedPoint.getRefreshTime()).isEqualTo(refreshTime);

    }
}