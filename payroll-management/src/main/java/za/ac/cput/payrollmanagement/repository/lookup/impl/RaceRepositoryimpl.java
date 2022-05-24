package za.ac.cput.payrollmanagement.repository.lookup.impl;

import za.ac.cput.payrollmanagement.domain.lookup.Race;
import za.ac.cput.payrollmanagement.repository.lookup.RaceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RaceRepositoryimpl implements RaceRepository {
    private static RaceRepositoryimpl RACE_REPOSITORY;
    private final List<Race> raceList;

    private RaceRepositoryimpl() {
        this.raceList = new ArrayList<>();
    }

    public static RaceRepositoryimpl raceRepository() {
        if (RACE_REPOSITORY == null) RACE_REPOSITORY = new RaceRepositoryimpl();
        return RACE_REPOSITORY;
    }

    public Race save(Race race) {
        Optional<Race> read = read(race.getId());
        if (read.isPresent()) {
            delete(read.get());
        }
        this.raceList.add(race);
        return race;
    }

    public Optional<Race> read(String id) {
        return this.raceList.stream().filter(g -> g.getId().equalsIgnoreCase(id)).findFirst();
    }

    public void delete(Race employeeIdentity) {
        // finds the employeeIdentity if needed and delete
        this.raceList.remove(employeeIdentity);
    }

    public List<Race> findAll() {
        return null;
    }
}
