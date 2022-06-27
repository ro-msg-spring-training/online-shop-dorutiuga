package ro.msg.learning.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ProductCategory")
@NoArgsConstructor

public class ProductCategory extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "productCategory")
    private List<Product> products;

    public ProductCategory(Integer id, String name, String description ) {
        super();
        super.setId(id);
        this.name = name;
        this.description = description;
    }
}
