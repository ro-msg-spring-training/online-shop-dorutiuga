package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entity.Supplier;
import ro.msg.learning.shop.repository.SupplierRepository;

@RequiredArgsConstructor
@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public void createSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public void deleteAllSuppliers() {
        supplierRepository.deleteAll();
    }

}
