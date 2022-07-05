package ro.msg.learning.shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "Revenue")
public class Revenue extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "sum")
    private BigDecimal sum;

}
