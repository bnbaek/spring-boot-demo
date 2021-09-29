package net.openu.mainDb.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.openu.MemberDto;
import net.openu.mainDb.domain.Member;
import net.openu.mainDb.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberDto.Data addMember(String id, String name) {
        return memberRepository.save(new Member(id, name)).toEntity();
    }

    public MemberDto.Data getMember(String id) {
        return memberRepository.findByMid(id)
            .map(Member::toEntity)
            .orElse(null);

    }

}
