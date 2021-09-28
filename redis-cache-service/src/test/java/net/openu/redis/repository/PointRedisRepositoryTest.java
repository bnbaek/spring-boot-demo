package net.openu.redis.repository;

import static org.junit.Assert.*;

import net.openu.redis.config.EmbeddedRedisConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {EmbeddedRedisConfig.class,PointRedisRepository.class})
@ActiveProfiles("local")
public class PointRedisRepositoryTest {

    @Autowired
    private PointRedisRepository pointRedisRepository;

    @Test
    public void di(){

    }

}