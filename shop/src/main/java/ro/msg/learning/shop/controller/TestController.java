package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.service.*;
import ro.msg.learning.shop.util.HandleH2Db;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
@Profile("test")
public class TestController {
    @Autowired
    private final StockService stockService;
    @Autowired
    private final SupplierService supplierService;
    @Autowired
    private final ProductCategoryService productCategoryService;
    @Autowired
    private final CustomerService customerService;
    @Autowired
    private final ProductService productService;
    @Autowired
    private final LocationService locationService;

    @PostMapping(value = "/populate", produces = {"application/json"})
    public void populate() {
        HandleH2Db handleH2Db = new HandleH2Db(stockService, supplierService, productCategoryService, customerService, productService, locationService);
        handleH2Db.populateDb();
    }

    @DeleteMapping(value = "/clear", produces = {"application/json"})
    public void clear() {
        HandleH2Db handleH2Db = new HandleH2Db(stockService, supplierService, productCategoryService, customerService, productService, locationService);
        handleH2Db.clearDb();
    }

}
