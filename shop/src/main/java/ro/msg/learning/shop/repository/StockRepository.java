package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.entity.Location;
import ro.msg.learning.shop.entity.Product;
import ro.msg.learning.shop.entity.Stock;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    @Query(value = "Select s from Stock s where s.product.id = :productId AND s.quantity >= :quantity order by s.quantity desc")
    List<Stock> findLocationByProductAndQuantity(@Param("productId") Integer productId, @Param("quantity") Integer quantity);
    Stock findByProductAndLocation(Product product, Location location);
}
