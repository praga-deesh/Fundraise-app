package org.company.fundraisedemo.donar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.attribute.standard.DocumentName;

import java.sql.SQLOutput;

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

}