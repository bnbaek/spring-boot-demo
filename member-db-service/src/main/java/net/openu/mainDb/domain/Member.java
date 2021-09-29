package net.openu.mainDb.domain;

import javax.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import net.openu.MemberDto;

@Getter

@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_seq")
    private Long seq;

    @Column(name = "member_id")
    private String mid;
    @Column(name = "member_name")
    private String name;


    public Member(String mid, String name) {
        this.mid = mid;
        this.name = name;
    }

    public MemberDto.Data toEntity(){
        return new MemberDto.Data(mid,name);
    }
}
