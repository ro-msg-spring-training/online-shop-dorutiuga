package ro.msg.learning.shop.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Customer")
@Data
public class Customer extends BaseEntity{
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

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;
}
