package za.ac.cput.payrollmanagement.repository.lookup;

import za.ac.cput.payrollmanagement.domain.lookup.IdentityType;
import za.ac.cput.payrollmanagement.repository.IRepository;

import java.util.List;

public interface IdentityTypeRepository extends IRepository<IdentityType, String> {
    List<IdentityType> findAll();
}
