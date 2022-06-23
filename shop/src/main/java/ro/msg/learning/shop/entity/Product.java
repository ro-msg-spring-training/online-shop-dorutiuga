package ro.msg.learning.shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Product")

public class Product extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;
    @Column(name = "weight")
    private double weight;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private ProductCategory productCategory;
    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    @Column(name = "imageUrl")
    private String imageUrl;

    @OneToMany(mappedBy = "product")
    private List<Stock> stocks;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
}