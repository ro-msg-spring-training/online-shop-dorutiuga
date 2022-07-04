package ro.msg.learning.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.dto.AddressDTO;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.OrderDetailDTO;
import ro.msg.learning.shop.mapper.OrderDetailMapper;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "Orders")
@NoArgsConstructor
public class Orders extends BaseEntity {

    @ManyToOne()
    @JoinColumn(name = "shippedFrom")
    private Location shippedFrom;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Column(name = "createdAt", columnDefinition = "DATE")
    private LocalDateTime createdAt;
    @Column(name = "addressCountry")
    private String addressCountry;
    @Column(name = "addressCity")
    private String addressCity;
    @Column(name = "addressCounty")
    private String addressCounty;
    @Column(name = "addressStreet")
    private String addressStreet;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderedProducts;

    public Orders(OrderDTO orderDTO) {
        super();

        this.orderedProducts = orderDTO.getProductsOrdered().stream().map(OrderDetailMapper::fromDtoToEntity).collect(Collectors.toList());
        this.createdAt = orderDTO.getCreatedAT();
        this.addressCountry = orderDTO.getDeliveryAddress().getAddressCountry();
        this.addressCounty = orderDTO.getDeliveryAddress().getAddressCounty();
        this.addressCity = orderDTO.getDeliveryAddress().getAddressCity();
        this.addressStreet = orderDTO.getDeliveryAddress().getAddressStreet();
    }

    public Orders(List<OrderDetailDTO> productsOrdered, LocalDateTime createdAT, AddressDTO deliveryAddress) {
        super();
        this.orderedProducts = productsOrdered.stream().map(OrderDetailMapper::fromDtoToEntity).collect(Collectors.toList());
        this.createdAt = createdAT;
        this.addressCountry = deliveryAddress.getAddressCountry();
        this.addressCounty = deliveryAddress.getAddressCounty();
        this.addressCity = deliveryAddress.getAddressCity();
        this.addressStreet = deliveryAddress.getAddressStreet();
    }
}
