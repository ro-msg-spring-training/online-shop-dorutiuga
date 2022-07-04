package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.entity.OrderDetail;
import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.mapper.OrderMapper;
import ro.msg.learning.shop.repository.CustomerRepository;
import ro.msg.learning.shop.repository.OrderDetailRepository;
import ro.msg.learning.shop.repository.OrdersRepository;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.strategy.LocationStrategy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    @Autowired
    private  OrdersRepository ordersRepository;

    @Autowired
    private LocationStrategy locationStrategy;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public  List<OrderDTO> getAllOrders() {
        return ordersRepository.findAll()
                .stream()
                .map(OrderMapper:: fromEntityToDto)
                .collect(Collectors.toList());
    }
    public  Orders createOrder(Orders order){

            List<Stock> stocks = locationStrategy.findLocation(order);

                    order.setShippedFrom(stocks.get(0).getLocation());
                    order.setCreatedAt(LocalDateTime.now());
                    order.setCustomer(customerRepository.findAll().get(0));

        ordersRepository.save(order);

            List<OrderDetail> products = order.getOrderedProducts();

            stocks.forEach(stock -> {
                for(OrderDetail productOrdered: products){
                    if (productOrdered.getId() == (stock.getProduct().getId())) {
                        int quantity = stock.getQuantity() - productOrdered.getQuantity();

                        Stock stockToUpdate = stockRepository.findByProductAndLocation(stock.getProduct(), stock.getLocation());
                        stockToUpdate.setQuantity(quantity);
                        stockRepository.save(stockToUpdate);

                        OrderDetail orderDetailToSave = OrderDetail.builder()
                                .order(order)
                                .product(stock.getProduct())
                                .quantity(productOrdered.getQuantity())
                                .build();

                        orderDetailRepository.save(orderDetailToSave);
                        break;
                    }

                }
            });
            return order;
    }
}
