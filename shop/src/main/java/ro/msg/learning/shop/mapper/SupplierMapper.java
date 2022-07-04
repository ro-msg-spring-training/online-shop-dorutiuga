package ro.msg.learning.shop.mapper;

import ro.msg.learning.shop.dto.SupplierDTO;
import ro.msg.learning.shop.entity.Supplier;

public class SupplierMapper {
    public static SupplierDTO fromEntityToDto(Supplier supplier) {
        return new SupplierDTO(
                supplier.getId(),
                supplier.getName()
        );
    }

    public static Supplier fromDtoToEntity(SupplierDTO supplierDTO) {
        return new Supplier(
                supplierDTO.getId(),
                supplierDTO.getName()
        );
    }
}
