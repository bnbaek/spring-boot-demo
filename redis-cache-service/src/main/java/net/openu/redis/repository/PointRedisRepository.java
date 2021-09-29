package net.openu.redis.repository;

import net.openu.redis.entity.Point;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRedisRepository extends CrudRepository<Point,String> {

}
