package ro.msg.learning.shop.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.exceptions.OutOfStockException;
import ro.msg.learning.shop.repository.StockRepository;

import java.util.ArrayList;
import java.util.List;

public class MostAbundantLocation implements LocationStrategy {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> findLocation(Orders orders) {

        List<Stock> locationStock = new ArrayList<>();
        orders.getOrderedProducts().forEach(product -> {
            List<Stock> stocks = stockRepository.findLocationByProductAndQuantity(product.getId(), product.getQuantity());
            if (stocks.isEmpty()) {
                throw new OutOfStockException(product.getId());
            }
            //because we query the products ordered by quantity(desc)we can now select the first stock to be the most abundant
            Stock stock = stocks.get(0);
            locationStock.add(new Stock(stock.getLocation(), stock.getProduct(), stock.getQuantity()));
        });
        return locationStock;
    }
}
