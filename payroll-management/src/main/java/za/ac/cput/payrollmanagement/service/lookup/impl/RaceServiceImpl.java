package za.ac.cput.payrollmanagement.service.lookup.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.payrollmanagement.domain.lookup.Race;
import za.ac.cput.payrollmanagement.repository.lookup.RaceRepository;
import za.ac.cput.payrollmanagement.repository.lookup.impl.RaceRepositoryimpl;
import za.ac.cput.payrollmanagement.service.lookup.RaceService;

import java.util.Optional;
@Service
public class RaceServiceImpl implements RaceService {
    private static RaceService SERVICE;
    private final RaceRepository repository;

    private RaceServiceImpl() {
        this.repository = RaceRepositoryimpl.raceRepository();
    }

    public static RaceService getService() {
        if (SERVICE == null) SERVICE = new RaceServiceImpl();
        return SERVICE;
    }

    @Override
    public Race save(Race race) {
        return this.repository.save(race);
    }

    @Override
    public Optional<Race> read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(Race race) {
        this.repository.delete(race);
    }
}
