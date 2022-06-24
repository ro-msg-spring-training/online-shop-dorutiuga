package ro.msg.learning.shop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name ="OrderDetail")
public class OrderDetail extends  BaseEntity{
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "quantity")
    private int quantity;
}
