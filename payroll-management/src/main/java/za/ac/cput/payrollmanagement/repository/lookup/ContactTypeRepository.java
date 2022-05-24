package za.ac.cput.payrollmanagement.repository.lookup;

import za.ac.cput.payrollmanagement.domain.lookup.ContactType;
import za.ac.cput.payrollmanagement.repository.IRepository;

import java.util.List;

public interface ContactTypeRepository extends IRepository<ContactType, String> {
    List<ContactType> findAll();
}
