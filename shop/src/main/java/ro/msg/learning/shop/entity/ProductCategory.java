package ro.msg.learning.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
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

}
