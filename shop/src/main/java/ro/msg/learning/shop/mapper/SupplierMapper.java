package ro.msg.learning.shop.mapper;

import ro.msg.learning.shop.dto.SupplierDTO;
import ro.msg.learning.shop.entity.Supplier;

public class SupplierMapper {
    public static SupplierDTO fromEntityToDto(Supplier supplier) {
        return new SupplierDTO(
                supplier.getId()
        );
    }

    public static Supplier fromDtoToEntity(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setId(supplierDTO.getId());
        return supplier;
    }
}
