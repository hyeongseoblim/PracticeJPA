package com.shop.item;

import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Book  extends Item{

private String author;
}
