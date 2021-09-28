//package net.openu.redis;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@Slf4j
////@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {RedisConfiguration.class})
//
//@RunWith(SpringRunner.class)
//@ActiveProfiles("test")
//@SpringBootTest
//
//public class RedisConfigurationTest {
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Test
//    public void di() {
//        System.out.println(stringRedisTemplate);
//        ValueOperations<String, String> vos = this.stringRedisTemplate.opsForValue();
//        String key = "myKey";
//        String val = "myVal";
//
//        vos.set(key, val);                              // create
//        Assertions.assertEquals(val, vos.get(key));     // read myVal
//        vos.set(key, val.toUpperCase());                // update
//        Assertions.assertEquals(val.toUpperCase(), vos.get(key));       // read MYVAL
//        this.stringRedisTemplate.delete(key);                           // delete
//        Assertions.assertNull(vos.get(key));                            // read null
//        Assertions.assertFalse(this.stringRedisTemplate.hasKey(key));   // exist false
//    }
//}