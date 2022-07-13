package ro.msg.learning.shop.unit;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ro.msg.learning.shop.TestBase;
import ro.msg.learning.shop.entity.OrderDetail;
import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.exception.OutOfStockException;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.strategy.MostAbundantLocation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class MostAbundantLocationTest extends TestBase {
    @InjectMocks
    private MostAbundantLocation strategy;
    @Mock
    private StockRepository stockRepository = Mockito.mock(StockRepository.class);

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        when(stockRepository.findLocationByProductAndQuantity(1, 1)).thenReturn(stocks);
        when(stockRepository.findLocationByProductAndQuantity(2, 100)).thenReturn(new ArrayList<>());
    }

    @Test
    void mostAbundantStrategySuccess() {
        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProduct(product);
        orderDetail.setQuantity(5);
        orderDetails.add(orderDetail);
        Orders order = new Orders();

        order.setOrderedProducts(orderDetails);
        order.setCreatedAt(LocalDateTime.now());

        order.setAddressCity("someCity");
        order.setAddressCounty("someCounty");
        order.setAddressCountry("someCountry");
        order.setAddressStreet("someStreet");

        List<Stock> stocks = strategy.findLocation(order);
        Assert.assertEquals("MAggs", stocks.get(0).getLocation().getName());


    }

    @Test
    public void mostAbundantStrategyTestFailDueToOutOfStock() {
        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setQuantity(100);
        orderDetail.setProduct(product2);
        orderDetails.add(orderDetail);
        Orders order = new Orders();
        order.setCreatedAt(LocalDateTime.now());
        order.setOrderedProducts(orderDetails);
        order.setAddressStreet("someStreet");
        order.setAddressCity("someCity");
        order.setAddressCountry("someCountry");
        order.setAddressCounty("someCounty");
        Throwable exception = Assert.assertThrows(OutOfStockException.class, () -> strategy.findLocation(order));
        Assert.assertEquals("The product " + orderDetail.getProduct().getId() +
                " is not in our stock right now", exception.getMessage());
    }
}