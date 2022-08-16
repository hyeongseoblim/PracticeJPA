package com.shop.order;


import com.shop.common.BaseEntity;
import com.shop.delivery.Delivery;
import com.shop.member.Member;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Table(name ="ORDERS")
public class Order extends BaseEntity {

    @Id
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    public void addOrderProduct(OrderProduct orderProduct){
        orderProducts.add(orderProduct);
        orderProduct.setOrder(this);
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

}
