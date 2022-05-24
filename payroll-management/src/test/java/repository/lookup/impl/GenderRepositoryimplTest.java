package repository.lookup.impl;

import za.ac.cput.payrollmanagement.domain.lookup.Gender;
import za.ac.cput.payrollmanagement.factory.lookup.GenderFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.payrollmanagement.repository.lookup.GenderRepository;
import za.ac.cput.payrollmanagement.repository.lookup.impl.GenderRepositoryimpl;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertSame;

class GenderRepositoryimplTest {
    private Gender gender;
    private GenderRepository repository;


    @BeforeEach
    void setUp() {
        this.gender = GenderFactory.build("test-id", "test-gender");
        this.repository = GenderRepositoryimpl.genderRepository();
        Gender saved = this.repository.save(this.gender);
        assertSame(this.gender, saved);
    }

    @AfterEach
    void tearDown() {
        this.repository.delete(this.gender);
        List<Gender> genderList = this.repository.findAll();
        assertEquals(0, genderList.size());
    }

    //GenderList gives NullPointerException
    @Test
    void read() {
        Optional<Gender> read = this.repository.read(this.gender.getId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(this.gender, read.get())
        );
    }

     //GenderList gives NullPointerException
    @Test
    void FindAll() {
        List<Gender> genderList = this.repository.findAll();
        assertEquals(0, genderList.size());
    }
}