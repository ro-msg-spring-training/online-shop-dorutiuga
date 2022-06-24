package ro.msg.learning.shop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "Location")
public class Location extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "addressCountry")
    private String addressCountry;
    @Column(name = "addressCity")
    private String addressCity;
    @Column(name = "addressCounty")
    private String addressCounty;
    @Column(name = "addressStreet")
    private String addressStreet;

    @OneToMany(mappedBy = "shippedFrom")
    private List<Orders> orders;

    @OneToMany(mappedBy = "location")
    private List<Revenue> revenues;

    @OneToMany(mappedBy = "location")
    private List<Stock> stocks;
}
