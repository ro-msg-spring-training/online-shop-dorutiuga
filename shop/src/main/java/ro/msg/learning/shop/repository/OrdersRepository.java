package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.entity.Orders;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    @Query(value = "Select o from Orders o where o.createdAt >= :atStart AND o.createdAt <= :atEnd ORDER BY o.createdAt DESC")
    List<Orders> findOrdersBetweenDates(LocalDateTime atStart, LocalDateTime atEnd);
}
