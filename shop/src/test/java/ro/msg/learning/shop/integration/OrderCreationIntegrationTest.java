package ro.msg.learning.shop.integration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ro.msg.learning.shop.ShopApplication;
import ro.msg.learning.shop.controller.TestController;
import ro.msg.learning.shop.entity.Customer;
import ro.msg.learning.shop.entity.OrderDetail;
import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.exception.OutOfStockException;
import ro.msg.learning.shop.service.CustomerService;
import ro.msg.learning.shop.service.OrderService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ShopApplication.class)
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-integrationtest.properties")

public class OrderCreationIntegrationTest extends TestBase {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    TestController testController;

    @BeforeAll
    public void init() {
        testController.populate();
    }

    @AfterAll
    public void after() {
        testController.clear();
    }

    @Test
    public void createOrderTestSuccessfully() {
        OrderDetail order = new OrderDetail();
        order.setProduct(product);
        order.setQuantity(10);
        OrderDetail order2 = new OrderDetail();
        order2.setProduct(product2);
        order2.setQuantity(15);
        List<OrderDetail> orderDetails = Arrays.asList(
                order, order2
        );

        Customer customer = customerService.findById(1);
        Orders orders = new Orders();
        orders.setOrderedProducts(orderDetails);
        orders.setCreatedAt(LocalDateTime.now());
        orders.setAddressCounty("someCountry");
        orders.setAddressCity("someCity");
        orders.setAddressStreet("someStreet");
        orders.setAddressCounty("someCounty");
        orders.setCustomer(customer);
        Orders orderToTest = orderService.createOrder(orders);

        Assert.assertNotNull(orderToTest);
    }

    @Test
    public void createOrderTestFailDueToOutOfStock() {
        OrderDetail order = new OrderDetail();
        order.setProduct(product);
        order.setQuantity(10);
        OrderDetail order2 = new OrderDetail();
        order2.setProduct(product2);
        order2.setQuantity(150);
        List<OrderDetail> orderDetails = Arrays.asList(
                order, order2
        );

        Customer customer = customerService.findById(1);
        Orders orders = new Orders();
        orders.setOrderedProducts(orderDetails);
        orders.setCreatedAt(LocalDateTime.now());
        orders.setAddressCounty("someCountry");
        orders.setAddressCity("someCity");
        orders.setAddressStreet("someStreet");
        orders.setAddressCounty("someCounty");
        orders.setCustomer(customer);
        Throwable exeption = Assert.assertThrows(OutOfStockException.class, () -> orderService.createOrder(orders));
        Assert.assertEquals("The product " +
                order2.getProduct().getId() + " is not in our stock right now", exeption.getMessage());
    }

}

