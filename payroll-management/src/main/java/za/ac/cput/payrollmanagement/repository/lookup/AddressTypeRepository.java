package za.ac.cput.payrollmanagement.repository.lookup;

import za.ac.cput.payrollmanagement.domain.lookup.AddressType;
import za.ac.cput.payrollmanagement.repository.IRepository;

import java.util.List;

public interface AddressTypeRepository extends IRepository<AddressType, String> {
    List<AddressType> findAll();
}
