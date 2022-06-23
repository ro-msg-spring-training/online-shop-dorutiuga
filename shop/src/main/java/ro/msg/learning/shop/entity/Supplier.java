package ro.msg.learning.shop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name = "Supplier")
public class Supplier extends BaseEntity{
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;
}
