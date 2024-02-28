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
    void createDonorProfileTest() {

        Donor actualDonarVal = new Donor("Asmithaa","asmithaa@gmail.com","string@123");
        Donor expectedDonar;
        Donor actualDonar = null;
        try {
            actualDonar = donorService.createDonorProfile(actualDonarVal);
        } catch (DonorExceptions e) {
            throw new RuntimeException(e);
        }
        expectedDonar = donorRepositoryDao.findById(actualDonar.getId()).get();
    //Assertions.assertNotNull(donorRepositoryDao.findById(expectedDonar.getId()));)
        Assertions.assertEquals(expectedDonar.getId(), actualDonar.getId());
        donorRepositoryDao.delete(actualDonar);
    }
    @Test
    void loginDonorTest()
    {
        Donor actualDonarVal = new Donor("shree","shree@gmail.com","string@800");
        Donor expectedDonor;
        Donor actualDonar = null;
        try {
            actualDonar = donorService.createDonorProfile(actualDonarVal);
        } catch (DonorExceptions e) {
            throw new RuntimeException(e);
        }
        expectedDonor=donorRepositoryDao.findByEmail(actualDonar.getEmail()).get();
        Assertions.assertEquals(expectedDonor.getEmail(),actualDonar.getEmail());
        Assertions.assertEquals(expectedDonor.getPassword(),actualDonar.getPassword());
        donorRepositoryDao.delete(actualDonar);
    }
    @Test
    void viewDonorByIdTest()
    {
        Donor actualDonarVal = new Donor("shree","shree@gmail.com","string@800");
        Donor expectedDonor;
        Donor actualDonar = null;
        try {
            actualDonar = donorService.createDonorProfile(actualDonarVal);
        } catch (DonorExceptions e) {
            throw new RuntimeException(e);
        }
        expectedDonor=donorRepositoryDao.findByEmail(actualDonar.getEmail()).get();
        Assertions.assertEquals(expectedDonor.getId(),actualDonar.getId());
        donorRepositoryDao.delete(actualDonar);
    }
    @Test
    void updateDonorNameByIdTest() throws DonorExceptions {
        Donor actualDonarVal = new Donor("chan","bonny@gmail.com","string@6600");
        Donor expectedDonor;
        Donor actualDonar = null;
        try {
            actualDonar = donorService.createDonorProfile(actualDonarVal);
        } catch (DonorExceptions e) {
            throw new RuntimeException(e);
        }
        Donor updatedDonor=donorService.updateDonorNameById(actualDonar.getId(),"bonyy");
        expectedDonor=donorRepositoryDao.findById(updatedDonor.getId()).get();
        Assertions.assertEquals(expectedDonor.getName(),updatedDonor.getName());
        donorRepositoryDao.delete(actualDonar);
    }

    @Test
    void updateDonorEmailByIdTest() throws DonorExceptions {
        Donor actualDonarVal = new Donor("chan","bonny@gmail.com","string@6600");
        Donor expectedDonor;
        Donor actualDonar = null;
        try {
            actualDonar = donorService.createDonorProfile(actualDonarVal);
        } catch (DonorExceptions e) {
            throw new RuntimeException(e);
        }
        Donor updatedDonor=donorService.updateDonorEmailById(actualDonar.getId(),"buji@gmail.com");
        expectedDonor=donorRepositoryDao.findById(updatedDonor.getId()).get();
        Assertions.assertEquals(expectedDonor.getEmail(),updatedDonor.getEmail());
        donorRepositoryDao.delete(actualDonar);
    }

    @Test
    void updateDonorPasswordByIdTest() throws DonorExceptions {
        Donor actualDonarVal = new Donor("chan","bonny@gmail.com","string@6600");
        Donor expectedDonor;
        Donor actualDonar = null;
        try {
            actualDonar = donorService.createDonorProfile(actualDonarVal);
        } catch (DonorExceptions e) {
            throw new RuntimeException(e);
        }
        Donor updatedDonor=donorService.updateDonorPasswordById(actualDonar.getId(),"buji@123");
        expectedDonor=donorRepositoryDao.findById(updatedDonor.getId()).get();
        Assertions.assertEquals(expectedDonor.getPassword(),updatedDonor.getPassword());
        donorRepositoryDao.delete(actualDonar);
    }

    @Test
    void deleteDonorByIdTest() throws DonorExceptions {
        Donor actualDonarVal = new Donor("chan","bonny@gmail.com","string@6600");
        Donor expectedDonor;
        Donor actualDonar = null;
        try {
            actualDonar = donorService.createDonorProfile(actualDonarVal);
        } catch (DonorExceptions e) {
            throw new RuntimeException(e);
        }
        expectedDonor=donorRepositoryDao.findById(actualDonar.getId()).get();
        donorService.deleteDonorById(actualDonar.getId());
        Donor finalActualDonar = actualDonar;
        assertThrows(DonorExceptions.class, () -> {
            donorService.deleteDonorById(finalActualDonar.getId());
        });

    }
}