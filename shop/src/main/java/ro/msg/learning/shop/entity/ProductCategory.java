package ro.msg.learning.shop.entity;

import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ProductCategory")
public class ProductCategory extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "productCategory")
    private List<Product> products;
}
