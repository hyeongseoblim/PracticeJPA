package com.shop.item;

import lombok.Getter;

import javax.persistence.Entity;

@Entity @Getter
public class Album extends Item {

    private String singer;

}
