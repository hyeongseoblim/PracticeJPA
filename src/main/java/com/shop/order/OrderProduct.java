package com.shop.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name="PRODUCT_ID")
    private Long productId;

    private Integer orderPrice;

    private  Integer count;

}
