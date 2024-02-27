package org.company.fundraisedemo.donar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.attribute.standard.DocumentName;

import java.sql.SQLOutput;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DonorServiceImplTest {

    @Autowired
    DonorRepositoryDao donorRepositoryDao;
    @Autowired
    DonorService donorService;



    @Test
    void createDonarProfileTest() {


        Donor actaulDonarVal = new Donor("kl","kl@gmail.com","kl");
        Donor expectedDonar;
        Donor actaulDonar = null;
        try {
            actaulDonar = donorService.createDonorProfile(actaulDonarVal);
        } catch (DonorExceptions e) {
            throw new RuntimeException(e);
        }
        expectedDonar = donorRepositoryDao.findById(actaulDonar.getId()).get();
    //Assertions.assertNotNull(donorRepositoryDao.findById(expectedDonar.getId()));)
        Assertions.assertEquals(expectedDonar.getId(), actaulDonar.getId());

        donorRepositoryDao.delete(actaulDonar);
    }
    @Test
    void loginDonorProfileTest(){
        Donor donor=new Donor("kl","kl@gmail.com","kl");
        try { donorService.createDonorProfile(donor);
            Donor loggedInDonor = donorService.loginDonorProfile(donor.getEmail(), donor.getPassword());
            assertNotNull(loggedInDonor);
            assertEquals(donor.getName(), loggedInDonor.getName());
            assertEquals(donor.getEmail(), loggedInDonor.getEmail());
            assertEquals(donor.getPassword(), loggedInDonor.getPassword());
        }
        catch (DonorExceptions e)
        {
            fail("Exception thrown while logging in donor profile: " + e.getMessage());
        }
    }
    @Test
    void updateDonorNameByIdTest() {
        Donor donor = new Donor("John", "john@example.com", "password");
        donor = donorRepositoryDao.save(donor);

        String newName = "John Doe";
        try {
            Donor updatedDonor = donorService.updateDonorNameById(donor.getId(), newName);
            assertEquals(newName, updatedDonor.getName());

            Optional<Donor> optionalDonor = donorRepositoryDao.findById(donor.getId());
            assertTrue(optionalDonor.isPresent());
            assertEquals(newName, optionalDonor.get().getName());
        } catch (DonorExceptions e) {
            fail("Exception thrown while updating donor's name: " + e.getMessage());
        }
    }
    @Test
    void deleteDonorByIdTest() {
        Donor donor = new Donor("Jane", "jane@example.com", "password");
        donor = donorRepositoryDao.save(donor);

        try {
            String result = donorService.deleteDonorById(donor.getId());
            assertEquals("Profile deleted successfully!!", result);

            Optional<Donor> optionalDonor = donorRepositoryDao.findById(donor.getId());
            assertFalse(optionalDonor.isPresent());
        } catch (DonorExceptions e) {
            fail("Exception thrown while deleting donor profile: " + e.getMessage());
        }
    }
}

