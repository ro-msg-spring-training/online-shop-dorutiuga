package ro.msg.learning.shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "Orders")
public class Orders extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "shippedFrom")
    private Location shippedFrom;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Column(name = "addressCountry")
    private String addressCountry;
    @Column(name = "addressCity")
    private String addressCity;
    @Column(name = "addressCounty")
    private String addressCounty;
    @Column(name = "addressStreet")
    private String addressStreet;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetailList;
}
