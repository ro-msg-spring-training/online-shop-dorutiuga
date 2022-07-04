package ro.msg.learning.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OrderDetail")
public class OrderDetail extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    public OrderDetail(Integer productId, Integer quantity) {
        super();
        super.setId(productId);
        this.quantity = quantity;

    }
}
