package com.shop.delivery;

import com.shop.common.BaseEntity;
import com.shop.order.Order;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    private String city;
    private String zipCode;
    private String street;

    @OneToOne(fetch = FetchType.LAZY)
    private Order order;

    @Enumerated(EnumType.STRING)
    DeliveryStatus deliveryStatus;
}
