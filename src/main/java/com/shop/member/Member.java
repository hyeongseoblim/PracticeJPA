package com.shop.member;

import com.shop.common.Address;
import com.shop.common.Period;
import com.shop.order.Order;
import com.shop.team.Team;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    private String name;

    @Embedded
    private Period workPeriod;

    @Embedded
    private Address HomeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))})
    private Address WorkAddress;

    @ElementCollection
    @CollectionTable(name="FAVORITE_FOOD", joinColumns = @JoinColumn(name="MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name="ADDRESS", joinColumns = @JoinColumn(name="MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();


    public void changeTeam(Team team) { //<<= 연관관계 편의 메소드..!
        this.team = team;
        team.getMembers().add(this);
    }

    @OneToMany(mappedBy = "member")
    List<Order> orders = new ArrayList<>();
}
