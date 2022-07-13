package ro.msg.learning.shop.unit;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ro.msg.learning.shop.TestBase;
import ro.msg.learning.shop.entity.OrderDetail;
import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.exception.OutOfStockException;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.strategy.SingleLocation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SingleLocationTest extends TestBase {
    @InjectMocks
    private SingleLocation strategy;
    @Mock
    private StockRepository stockRepository = Mockito.mock(StockRepository.class);

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        when(stockRepository.findLocationByProductAndQuantity(1, 10)).thenReturn(stocks);
        when(stockRepository.findLocationByProductAndQuantity(2, 800)).thenReturn(new ArrayList<>());
    }

    @Test
    void singleLocationStrategySuccess() {
        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProduct(product);
        orderDetail.setQuantity(10);
        orderDetails.add(orderDetail);
        Orders order = new Orders();

        order.setOrderedProducts(orderDetails);
        order.setCreatedAt(LocalDateTime.now());

        order.setAddressCity("someCity");
        order.setAddressCounty("someCounty");
        order.setAddressCountry("someCountry");
        order.setAddressStreet("someStreet");

        List<Stock> stocks = strategy.findLocation(order);
        Assertions.assertFalse(stocks.isEmpty());
    }

    @Test()
    void singleLocationStrategyFailDueToOutOfStock() {


        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        OrderDetail orderDetail2 = new OrderDetail();

        orderDetail.setProduct(product);
        orderDetail2.setProduct(product2);
        orderDetail.setQuantity(10);
        orderDetail2.setQuantity(800);

        orderDetails.add(orderDetail);
        orderDetails.add(orderDetail2);
        Orders order = new Orders();

        order.setOrderedProducts(orderDetails);
        order.setCreatedAt(LocalDateTime.now());

        order.setAddressCity("someCity");
        order.setAddressCounty("someCounty");
        order.setAddressCountry("someCountry");
        order.setAddressStreet("someStreet");

        Throwable exception = Assert.assertThrows(OutOfStockException.class, () -> strategy.findLocation(order));
        Assert.assertEquals("The product " + order.getOrderedProducts().get(1).getId() +
                " is not in our stock right now", exception.getMessage());


    }

}