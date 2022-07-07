package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.mapper.StockMapper;
import ro.msg.learning.shop.service.StockService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/csv-export")
public class StockController {

    private final StockService stockService;

    @GetMapping(value = "/{locationId}", produces = {"text/csv"})
    public List<StockDTO> exportStock(@PathVariable Integer locationId, HttpServletResponse response) {
        response.setHeader("Content-Disposition", "attachment; filename=exportedStocks.csv");
        List<Stock> stocksToExport = stockService.exportStocks(locationId);
        return StockMapper.fromListEntityToListDto(stocksToExport);
    }
}
