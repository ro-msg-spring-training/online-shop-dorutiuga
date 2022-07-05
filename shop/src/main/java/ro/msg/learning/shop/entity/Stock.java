package ro.msg.learning.shop.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Stock")
@JsonPropertyOrder()
public class Stock extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;
    @Column(name = "quantity")
    private int quantity;

    public Stock(Location location, Product product, int quantity) {
        super();
        this.location = location;
        this.product = product;
        this.quantity = quantity;
    }
}
