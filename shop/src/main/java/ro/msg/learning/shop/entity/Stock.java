package ro.msg.learning.shop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Stock")
public class Stock extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;
    @Column(name = "quantity")
    private int quantity;
}
