package ro.msg.learning.shop.mapper;

import ro.msg.learning.shop.dto.AddressDTO;


public class AddressMapper {

    public static AddressDTO fromEntityToDto(String addressCountry, String addressCounty, String addressCity, String addressStreet) {
        return new AddressDTO(
                addressCountry,
                addressCounty,
                addressCity,
                addressStreet
        );
    }
}
