package ro.msg.learning.shop.mapper;

import ro.msg.learning.shop.dto.CustomerDTO;
import ro.msg.learning.shop.entity.Customer;

public class CustomerMapper {
    public static CustomerDTO fromEntityToDto(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getUsername(),
                customer.getEmailAddress()
        );
    }
}
