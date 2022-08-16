package com.shop.team;

import com.shop.common.BaseEntity;
import com.shop.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Team extends BaseEntity {

    @Id
    @Column(name="TEAM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    List<Member> members = new ArrayList<Member>();
    //mappedBy ? <- 1:N 관계에서 반대편의 무슨 값이랑 걸려 있는지 확인 시켜주는것

    public void addMember(Member member){
        this.getMembers().add(member);
    }
}
