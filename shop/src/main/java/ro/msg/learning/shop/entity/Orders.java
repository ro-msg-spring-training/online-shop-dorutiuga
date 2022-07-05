package ro.msg.learning.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "Orders")
@NoArgsConstructor
public class Orders extends BaseEntity {

    @ManyToOne()
    @JoinColumn(name = "shippedFrom")
    private Location shippedFrom;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Column(name = "createdAt", columnDefinition = "DATE")
    private LocalDateTime createdAt;
    @Column(name = "addressCountry")
    private String addressCountry;
    @Column(name = "addressCity")
    private String addressCity;
    @Column(name = "addressCounty")
    private String addressCounty;
    @Column(name = "addressStreet")
    private String addressStreet;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderedProducts;


}
