package za.ac.cput.payrollmanagement.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.payrollmanagement.domain.lookup.AddressType;
import za.ac.cput.payrollmanagement.factory.lookup.AddressTypeFactory;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressTypeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private AddressTypeController controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private AddressType addressType;
    private String baseUrl;

    @BeforeEach
     void setUp() {
        Assertions.assertNotNull(controller);
        this.addressType = AddressTypeFactory.build("test-id", "test-name");
        this.baseUrl = "http://localhost: " + this.port + "/payroll/address-type";
    }

    @Test
   void save() {
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.addressType.getId();
        System.out.println(url);
        ResponseEntity<AddressType> response = this.restTemplate.postForEntity(url, "", AddressType.class);
        assertAll(() -> assertEquals(HttpStatus.OK, response.getStatusCode()));
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }
}