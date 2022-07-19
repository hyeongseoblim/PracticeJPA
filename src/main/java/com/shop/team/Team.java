package com.shop.team;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Team {

    @Id
    @Column(name="TEAM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
