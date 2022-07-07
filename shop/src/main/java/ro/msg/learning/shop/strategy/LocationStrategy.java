package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.entity.Stock;

import java.util.List;

public interface LocationStrategy {
    List<Stock> findLocation(Orders order);
}
