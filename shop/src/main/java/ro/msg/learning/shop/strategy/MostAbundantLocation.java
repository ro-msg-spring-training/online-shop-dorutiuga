package ro.msg.learning.shop.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.exception.OutOfStockException;
import ro.msg.learning.shop.repository.StockRepository;

import java.util.ArrayList;
import java.util.List;

public class MostAbundantLocation implements LocationStrategy {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> findLocation(Orders orders) {

        List<Stock> stockLocation = new ArrayList<>();
        orders.getOrderedProducts().forEach(orderDetail -> {
            List<Stock> stocks = stockRepository.findLocationByProductAndQuantity(orderDetail.getProduct().getId(), orderDetail.getQuantity());
            if (stocks.isEmpty()) {
                throw new OutOfStockException(orderDetail.getProduct().getId());
            }
            //because we query the products ordered by quantity(desc)we can now select the first stock to be the most abundant
            Stock stock = stocks.get(0);
            stockLocation.add(new Stock(stock.getLocation(), stock.getProduct(), stock.getQuantity()));
        });
        return stockLocation;
    }
}
