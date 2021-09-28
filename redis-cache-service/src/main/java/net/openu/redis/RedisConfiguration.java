//package net.openu.redis;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisClusterConfiguration;
//import org.springframework.data.redis.connection.RedisClusterNode;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisPassword;
//import org.springframework.data.redis.connection.RedisSentinelConfiguration;
//import org.springframework.data.redis.connection.RedisSocketConfiguration;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//@Configuration
//public class RedisConfiguration {
//
//    @Value("${spring.data.redis.host:127.0.0.1}")
//    private String redisHostName;
//
//    @Value("${spring.data.redis.socket:/var/run/redis/redis.sock}")
//    private String redisSocket;
//
//    @Value("${spring.data.redis.password:}")
//    private String redisPassword;
//
//    @Value("${spring.data.redis.port:6379}")
//    private int redisPort;
//
//    @Value("${spring.redis.timeout:60}")
//    private int redisTimeOut;
//
//    //    @Bean
////    public RedisConnectionFactory redisConnectionFactory() {
////
////        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
////        poolConfig.setMaxIdle(10);
////        poolConfig.setMaxTotal(10);
////        poolConfig.setMinIdle(2);
////
////        LettuceClientConfiguration lettuceClientConfiguration =
////            LettucePoolingClientConfiguration.builder().poolConfig(poolConfig)
////                .commandTimeout(Duration.ofSeconds(5)).build();
////
////        return new LettuceConnectionFactory(redisStandaloneConfiguration(), lettuceClientConfiguration);
////        //return new LettuceConnectionFactory(redisSentinelConfiguration());
////        //return new LettuceConnectionFactory(redisSocketConfiguration());
////        //return new LettuceConnectionFactory(redisClusterConfiguration());
////    }
//    private RedisSocketConfiguration redisSocketConfiguration() {
//        RedisSocketConfiguration redisSocketConfiguration = new RedisSocketConfiguration(this.redisSocket);
//        redisSocketConfiguration.setPassword(RedisPassword.of(redisPassword));
//        return redisSocketConfiguration;
//    }
//
//    private RedisStandaloneConfiguration redisStandaloneConfiguration() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHostName,
//            redisPort);
////        redisStandaloneConfiguration.setPassword(RedisPassword.of(redisPassword));
//        return redisStandaloneConfiguration;
//    }
//
//    private RedisClusterConfiguration redisClusterConfiguration() {
//        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
//        redisClusterConfiguration.addClusterNode(new RedisClusterNode("192.168.56.21", 7001));
//        redisClusterConfiguration.addClusterNode(new RedisClusterNode("192.168.56.21", 7002));
//        redisClusterConfiguration.addClusterNode(new RedisClusterNode("192.168.56.21", 7003));
//        redisClusterConfiguration.addClusterNode(new RedisClusterNode("192.168.56.21", 7004));
//        redisClusterConfiguration.addClusterNode(new RedisClusterNode("192.168.56.21", 7005));
//        redisClusterConfiguration.addClusterNode(new RedisClusterNode("192.168.56.21", 7006));
//        return redisClusterConfiguration;
//    }
//
//    private RedisSentinelConfiguration redisSentinelConfiguration() {
//        return new RedisSentinelConfiguration().master("mymaster").sentinel("redis.sentinel.net", 5000);
//    }
//
////    @Bean
////    public RedisTemplate<String, Box> redisTemplate() {
////        ObjectMapper objectMapper = new ObjectMapper();
////        objectMapper.registerModule(new JavaTimeModule());
////
////        Jackson2JsonRedisSerializer<Box> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Box.class);
////        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
////
////        RedisTemplate<String, Box> redisTemplate = new RedisTemplate<>();
////        redisTemplate.setConnectionFactory(redisConnectionFactory());
////        redisTemplate.setKeySerializer(new StringRedisSerializer());
////        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
////        return redisTemplate;
////    }
//
////    @Bean
////    public StringRedisTemplate stringRedisTemplate() {
////        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
////        stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
////        stringRedisTemplate.setValueSerializer(new StringRedisSerializer());
////        stringRedisTemplate.setConnectionFactory(redisConnectionFactory());
////        return stringRedisTemplate;
////    }
//
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory(redisHostName, redisPort);
//    }
//
////    @Bean
////    public RedisTemplate<?, ?> redisTemplate() {
////        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
////        redisTemplate.setConnectionFactory(redisConnectionFactory());
////        return redisTemplate;
////    }
//
//    @Bean
//    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connectionFactory) {
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//        stringRedisTemplate.setConnectionFactory(connectionFactory);
//
//        return stringRedisTemplate;
//    }
//}
