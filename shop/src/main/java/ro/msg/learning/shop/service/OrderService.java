package ro.msg.learning.shop.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entity.OrderDetail;
import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.repository.CustomerRepository;
import ro.msg.learning.shop.repository.OrderDetailRepository;
import ro.msg.learning.shop.repository.OrdersRepository;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.strategy.LocationStrategy;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private LocationStrategy locationStrategy;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;


    public Orders createOrder(Orders order) {

        List<Stock> stocks = locationStrategy.findLocation(order);
        try {
            order.setShippedFrom(stocks.get(0).getLocation());
            order.setCreatedAt(LocalDateTime.now());
            order.setCustomer(customerRepository.findAll().get(0));
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("We don't have all products in stock right now");
        }

        ordersRepository.save(order);

        List<OrderDetail> orderDetailsProducts = order.getOrderedProducts();
        stocks.forEach(stock -> {
            for (OrderDetail orderDetails : orderDetailsProducts) {

                if (orderDetails.getProduct().getId() == (stock.getProduct().getId())) {
                    int quantity = stock.getQuantity() - orderDetails.getQuantity();
                    Stock stockToUpdate = stockRepository.findByProductAndLocation(stock.getProduct(), stock.getLocation());
                    stockToUpdate.setQuantity(quantity);
                    orderDetails.setOrder(order);
                    stockRepository.save(stockToUpdate);
                    orderDetailRepository.save(orderDetails);

                }
            }
        });
        return order;
    }
}
