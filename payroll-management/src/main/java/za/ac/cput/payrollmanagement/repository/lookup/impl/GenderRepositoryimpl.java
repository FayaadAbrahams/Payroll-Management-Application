package za.ac.cput.payrollmanagement.repository.lookup.impl;

import za.ac.cput.payrollmanagement.domain.lookup.Gender;
import za.ac.cput.payrollmanagement.repository.lookup.GenderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Responsible for CRUD into a data store
public class GenderRepositoryimpl implements GenderRepository {
    private static GenderRepositoryimpl GENDER_REPOSITORY;
    private final List<Gender> genderList;

    private GenderRepositoryimpl() {
        this.genderList = new ArrayList<>();
    }

    public static GenderRepositoryimpl genderRepository() {
        if (GENDER_REPOSITORY == null) GENDER_REPOSITORY = new GenderRepositoryimpl();
        return GENDER_REPOSITORY;
    }

    public Gender save(Gender gender) {
        // Check if gender exists, if yes update and return if success
        Optional<Gender> read = read(gender.getId());
        if (read.isPresent()) {
            delete(read.get());
        }
        this.genderList.add(gender);
        return gender;
    }

    public Optional<Gender> read(String id) {
        return this.genderList.stream().filter(g -> g.getId().equalsIgnoreCase(id)).findFirst();
    }

    public void delete(Gender employeeIdentity) {
        // finds the employeeIdentity if needed and delete
        this.genderList.remove(employeeIdentity);
    }

    public List<Gender> findAll() {
        return null;
    }

}
