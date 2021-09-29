package net.openu.mainDb.repository;

import java.util.Optional;
import net.openu.mainDb.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMid(String mid);
}
