package ro.msg.learning.shop.mapper;

import ro.msg.learning.shop.dto.LocationDTO;
import ro.msg.learning.shop.entity.Location;

public class LocationMapper {
    public static LocationDTO fromEntityToDto(Location location) {
        return new LocationDTO(
                location.getName(),
                location.getAddressCountry(),
                location.getAddressCity(),
                location.getAddressCounty(),
                location.getAddressStreet()
        );
    }

    public static Location fromDtoToEntity(LocationDTO locationDTO) {
        Location location = new Location();
        location.setName(locationDTO.getName());
        location.setAddressCountry(locationDTO.getAddressCountry());
        location.setAddressCity(locationDTO.getAddressCity());
        location.setAddressCounty(locationDTO.getAddressCounty());
        location.setAddressStreet(locationDTO.getAddressStreet());
        return location;
    }
}
