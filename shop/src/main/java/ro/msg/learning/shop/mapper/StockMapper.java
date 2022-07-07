package ro.msg.learning.shop.mapper;

import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.entity.Stock;

import java.util.ArrayList;
import java.util.List;

public class StockMapper {


    public static StockDTO fromEntityToDto(Stock stock) {

        return StockDTO.builder()
                .quantity(stock.getQuantity())
                .productName(stock.getProduct().getName())
                .locationName(stock.getLocation().getName())
                .build();
    }

    public static List<StockDTO> fromListEntityToListDto(List<Stock> stocks) {
        List<StockDTO> dtoResult = new ArrayList<>();
        for (Stock createdStocks : stocks) {
            dtoResult.add(fromEntityToDto(createdStocks));
        }
        return dtoResult;
    }
}
