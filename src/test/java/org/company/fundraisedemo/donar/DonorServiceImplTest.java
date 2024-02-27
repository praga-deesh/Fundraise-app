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
}