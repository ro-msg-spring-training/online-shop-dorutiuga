package ro.msg.learning.shop.exception;

public class ProductNotExistsException extends RuntimeException {
    public ProductNotExistsException(Integer id) {
        super("The product " + id + " does not exists");
    }
}
