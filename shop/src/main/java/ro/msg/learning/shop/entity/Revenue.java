package ro.msg.learning.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Revenue")
public class Revenue extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;

    @Column(name = "date", columnDefinition = "DATE")
    private LocalDateTime date;

    @Column(name = "sum")
    private BigDecimal sum;

}
