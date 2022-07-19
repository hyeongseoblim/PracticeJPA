package com.shop.member;

import com.shop.team.Team;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "MEMBERS")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;

    //여러 멤버가 하나의 팀에 속할 수 있음.
    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    private String name;

    private String city;

    private String street;

    private String zipcode;

}
