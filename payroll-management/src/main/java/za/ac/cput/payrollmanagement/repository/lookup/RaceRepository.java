package za.ac.cput.payrollmanagement.repository.lookup;

import za.ac.cput.payrollmanagement.domain.lookup.Race;
import za.ac.cput.payrollmanagement.repository.IRepository;

import java.util.List;

public interface RaceRepository extends IRepository<Race, String> {
    List<Race> findAll();
}
