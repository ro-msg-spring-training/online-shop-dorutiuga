package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entity.Location;
import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.exception.NoLocationForStocksException;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.StockRepository;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class StockService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> exportStocks(Integer locationId) {
        List<Stock> stocks;
        Optional<Location> location = locationRepository.findById(locationId);
        if (location.isPresent()) {
            stocks = stockRepository.findByLocationId(locationId);
            return stocks;
        } else throw new NoLocationForStocksException("We can't find the location with id " + locationId);
    }
}
