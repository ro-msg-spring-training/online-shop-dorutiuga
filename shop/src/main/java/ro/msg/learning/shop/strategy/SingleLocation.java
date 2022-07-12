package ro.msg.learning.shop.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.exception.OutOfStockException;
import ro.msg.learning.shop.repository.StockRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleLocation implements LocationStrategy {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> findLocation(Orders order) {
        Map<Integer, List<Stock>> locations = new HashMap<>();
        order.getOrderedProducts().forEach(orderDetail -> {
                    List<Stock> stocks = stockRepository
                            .findLocationByProductAndQuantity(orderDetail.getProduct().getId(), orderDetail.getQuantity());
                    if (stocks.isEmpty()) {
                        throw new OutOfStockException(orderDetail.getId());
                    }

                    stocks.forEach(stock -> {
                        List<Stock> locationList = locations.get(stock.getLocation().getId());
                        if (locationList == null) {
                            locationList = new ArrayList<>();
                        }
                        locationList.add(new Stock(stock.getLocation(), stock.getProduct(), stock.getQuantity()));
                        locations.put(stock.getLocation().getId(), locationList);
                    });
                }
        );
        for (Map.Entry<Integer, List<Stock>> entry : locations.entrySet()) {
            if (entry.getValue().size() == order.getOrderedProducts().size()) {
                return entry.getValue();
            }
        }
        return new ArrayList<>();
    }
}
