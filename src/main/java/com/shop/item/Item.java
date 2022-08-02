package com.shop.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
//@Inheritance(strategy = I)
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.JOINED)
/*
* Inheritance
*   JOINED - 조인 전략
*   SINGLETABLE - JPA 기본 전략 성능상 이점이 존재 - DTYPE 필수 존재. 구분지을 값이 필요하기 때문.
*   TABLE_PEF_CLASS - 다중 테이블 전략 - 부모가 되는 엔티티의 테이블이 만들어지지 않음. (단 추상 클래스로 만들었을 경우만)
*
* Discriminator
*   Column - 자식의 타입이 명시되는 컬럼 (DTYPE) 엔티티 명이 들어간다.
*   Value - 자식 클래스에서 특정 값을 명시하면 DTYPE 값에 명시한 값이 들어간다
* */
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long price;
}
