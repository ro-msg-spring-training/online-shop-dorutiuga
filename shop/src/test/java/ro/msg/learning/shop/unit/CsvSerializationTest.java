package ro.msg.learning.shop.unit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ro.msg.learning.shop.TestBase;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.util.CsvConvertor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvSerializationTest extends TestBase {
    private static final String CSV = "locationName,productName,quantity\nMAggs,\"BIO Carrots\",20\n";

    public CsvConvertor<StockDTO> csvConversion = new CsvConvertor<>();


    @Test
    public void toCsvTestSuccess() throws IOException {
        List<StockDTO> existingStocks = new ArrayList<>();
        existingStocks.add(new StockDTO("MAggs", "BIO Carrots", 20));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        csvConversion.toCsv(StockDTO.class, existingStocks, outputStream);

        Assert.assertEquals(CSV, new String(outputStream.toByteArray()));
    }

}
