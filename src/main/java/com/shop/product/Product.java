package com.shop.product;

import com.shop.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Product extends BaseEntity {

    @Id
    @Column(name = "PRODUCT_ID")
    private Long id;

    private String name;

    private Integer price;

    private Integer stockQuantity;

}
