package ro.msg.learning.shop.unit;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.entity.Stock;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.service.StockService;
import ro.msg.learning.shop.util.CsvConvertor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class CsvSerialization extends TestBase {
    private static final String CSV = "locationName,productName,quantity\nMAggs,\"BIO Carrots\",20\n";

    public CsvConvertor<StockDTO> csvConversion = new CsvConvertor<>();

//    @Mock
//    public StockRepository stockRepository = Mockito.mock(StockRepository.class);
//
//    @Mock
//    public StockService stockService = Mockito.mock(StockService.class);
//    @Mock
//    public LocationRepository locationRepository = Mockito.mock(LocationRepository.class);


//    @BeforeEach
//    public void init() {
//        MockitoAnnotations.openMocks(this);
//        when(locationRepository.findById(1)).thenReturn(Optional.ofNullable(optionalLocation));
//        when(stockRepository.findByLocationId(1)).thenReturn(stocks);
//    }

@Test
public void toCsvTestSuccess() throws IOException {
    List<StockDTO> existingStocks = new ArrayList<>();
     Stock stockToAdd = new Stock();
    existingStocks.add(new StockDTO( "MAggs", "BIO Carrots", 20));
//    stockToAdd.setLocationName("MAggs");
//    stockToAdd.setProductName("BIO Carrots");
//    stockToAdd.setQuantity(20);
//    existingStocks.add(stockToAdd);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    csvConversion.toCsv(StockDTO.class, existingStocks, outputStream);

    Assert.assertEquals(CSV, new String(outputStream.toByteArray()));
}

}
