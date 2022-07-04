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
        return new Location(
                locationDTO.getName(),
                locationDTO.getAddressCountry(),
                locationDTO.getAddressCity(),
                locationDTO.getAddressCounty(),
                locationDTO.getAddressStreet()
        );
    }
}
