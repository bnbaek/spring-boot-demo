package net.openu.redis.service;

import lombok.RequiredArgsConstructor;
import net.openu.redis.repository.PointRedisRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PointRedisService {
    private final PointRedisRepository pointRedisRepository;


}
