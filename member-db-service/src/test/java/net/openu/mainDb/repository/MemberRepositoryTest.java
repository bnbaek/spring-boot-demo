package net.openu.mainDb.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

import net.openu.mainDb.domain.Member;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @BeforeAll
    public void initialize(){
        System.out.println("qqqqqq");
        Member entity = new Member("bbn", "마테오");
        Member saved = memberRepository.save(entity);
    }

    @Test
    public void 회원_저장(){
        String mid = "bbn";
        Member getMember = memberRepository.findByMid(mid).orElse(null);

        assertThat(mid).isEqualTo(getMember.getMid());
        assertThat("마테오").isEqualTo(getMember.getName());

    }
}