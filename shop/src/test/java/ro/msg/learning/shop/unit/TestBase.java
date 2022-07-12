package ro.msg.learning.shop.unit;

import ro.msg.learning.shop.entity.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestBase {
    protected ProductCategory productCategory = ProductCategory.builder().id(1).name("Jewelry").description("For more than a century, Swarovski has put the sparkle in gowns, tiaras, jewelry, sculptures, and even luxury cars.").build();
    protected Supplier supplier = Supplier.builder().id(1).name("Charter Supply").build();
    protected Product product = Product.builder().id(1).name("BIO Carrots").description("Swarovski has put the sparkle in gowns, tiaras, jewelry, sculptures, and even luxury cars.)").price(91.97).weight(8.22).imageUrl("https://picsum.photos/200/300").productCategory(productCategory).supplier(supplier).build();
    protected Product product2 = Product.builder().id(2).name("Swarovski").description("Swarovski has put the sparkle in gowns, tiaras, jewelry, sculptures, and even luxury cars.)").price(91.97).weight(8.22).imageUrl("https://picsum.photos/200/300").productCategory(productCategory).supplier(supplier).build();
    protected Location location = Location.builder().id(1).name("MAggs").addressCountry("HR").addressCity("Piskorevci").addressCounty("").addressStreet("506 Mitchell Court").build();
    protected Location location2 = Location.builder().id(2).name("Jaxspan").addressCountry("MK").addressCity("Mapnho").addressCounty("").addressStreet("578 Spaight Trail").build();
    protected Stock stock = Stock.builder().id(1).location(location).product(product).quantity(100).build();
    protected Stock stock2 = Stock.builder().id(2).location(location2).product(product).quantity(10).build();
    protected List<Stock> stocks = Stream.of(stock, stock2).collect(Collectors.toList());

    protected Location optionalLocation = Location.builder().id(1).addressCity("someCity").addressStreet("someStreet").addressCounty("someCounty").addressCountry("someCountry").build();






}
