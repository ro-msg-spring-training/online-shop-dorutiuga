package ro.msg.learning.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@NoArgsConstructor
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
    @JsonIgnore
    @OneToMany(mappedBy = "shippedFrom")
    private List<Orders> orders;
    @JsonIgnore
    @OneToMany(mappedBy = "location")
    private List<Revenue> revenues;
    @JsonIgnore
    @OneToMany(mappedBy = "location")
    private List<Stock> stocks;

    public Location(String name, String addressCountry, String addressCity, String addressCounty, String addressStreet) {
        super();
        this.name = name;
        this.addressCountry = addressCountry;
        this.addressCity = addressCity;
        this.addressCounty = addressCounty;
        this.addressStreet = addressStreet;
    }
}
