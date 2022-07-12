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

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@Table(name = "Supplier")
@NoArgsConstructor
public class Supplier extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

}
