package ro.msg.learning.shop.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@SuperBuilder
@Table(name = "Customer")
@Data
@NoArgsConstructor
public class Customer extends BaseEntity {
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "emailAddress")
    private String emailAddress;
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;
}
