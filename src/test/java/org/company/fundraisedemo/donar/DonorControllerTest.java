package org.company.fundraisedemo.donar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DonorControllerTest
{
//    @Autowired
//    private DonorService donorService;
//
//    @Autowired
//    private DonorRepositoryDao donorRepositoryDao;
//
//    @Test
//    void createDonorTest()
//    {
//        // Prepare a new donor
//        Donor newDonor = new Donor("John Doe", "johndoe@example.com", "password@123");
//
//        // Invoke the createDonorProfile method directly
//        Donor savedDonor = null;
//        try {
//            savedDonor = donorService.createDonorProfile(newDonor);
//        } catch (DonorExceptions e) {
//            assertEquals("Account already exits..so try logging in", e.getMessage());
//        }
//
//        // Verify the saved donor
//        assertNotNull(savedDonor);
//        assertEquals("John Doe", savedDonor.getName());
//        assertEquals("johndoe@example.com", savedDonor.getEmail());
//        assertEquals("password@123", savedDonor.getPassword());
//    }
//
//    @Test
//    void loginDonorTest() {
//    }
//
//    @Test
//    void viewDonorTest() {
//    }
//
//    @Test
//    void updateDonorNameTest() {
//    }
//
//    @Test
//    void updateDonorEmail() {
//    }
//
//    @Test
//    void updateDonorPasswordTest() {
//    }
//
//    @Test
//    void deleteDonorTest() {
//    }
}