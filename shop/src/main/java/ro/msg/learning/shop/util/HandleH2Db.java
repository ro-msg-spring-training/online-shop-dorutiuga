package ro.msg.learning.shop.util;

import lombok.AllArgsConstructor;
import ro.msg.learning.shop.entity.*;
import ro.msg.learning.shop.service.*;

@AllArgsConstructor
public class HandleH2Db {
    private final StockService stockService;
    private final SupplierService supplierService;
    private final ProductCategoryService productCategoryService;
    private final CustomerService customerService;
    private final ProductService productService;
    private final LocationService locationService;

    public void populateDb() {
        Customer customer = Customer.builder().id(1).firstName("test").lastName("test").username("test").emailAddress("email@gmail.com").password("test").build();
        Supplier supplier = Supplier.builder().id(1).name("Charter Supply").build();
        ProductCategory productCategory = ProductCategory.builder().id(1).name("Jewelry").description("For more than a century, Swarovski has put the sparkle in gowns, tiaras, jewelry, sculptures, and even luxury cars.").build();
        Product product = Product.builder().id(1).name("BIO Carrots").description("Swarovski has put the sparkle in gowns, tiaras, jewelry, sculptures, and even luxury cars.)").price(91.97).weight(8.22).imageUrl("https://picsum.photos/200/300").productCategory(productCategory).supplier(supplier).build();
        Product product2 = Product.builder().id(2).name("Swarovski").description("Swarovski has put the sparkle in gowns, tiaras, jewelry, sculptures, and even luxury cars.)").price(91.97).weight(8.22).imageUrl("https://picsum.photos/200/300").productCategory(productCategory).supplier(supplier).build();
        Location location = Location.builder().id(1).name("MAggs").addressCountry("HR").addressCity("Piskorevci").addressCounty("").addressStreet("506 Mitchell Court").build();
        Location location2 = Location.builder().id(2).name("Jaxspan").addressCountry("MK").addressCity("Mapnho").addressCounty("").addressStreet("578 Spaight Trail").build();
        Stock stock = Stock.builder().id(1).location(location).product(product).quantity(10).build();
        Stock stock2 = Stock.builder().id(2).location(location2).product(product2).quantity(100).build();
        Stock stock3 = Stock.builder().location(location).product(product2).quantity(10).build();

        customerService.createCustomer(customer);
        supplierService.createSupplier(supplier);
        productCategoryService.createProductCategory(productCategory);
        locationService.createLocation(location);
        locationService.createLocation(location2);
        productService.createProduct(product);
        productService.createProduct(product2);
        stockService.createStock(stock);
        stockService.createStock(stock2);
        stockService.createStock(stock3);
    }

    public void clearDb() {
        customerService.deleteAllCustomers();
        supplierService.deleteAllSuppliers();
        productCategoryService.deleteProductCategory();
        locationService.deleteAllLocation();
        productService.deleteAllProducts();
        stockService.deleteAllStocks();
    }

}
