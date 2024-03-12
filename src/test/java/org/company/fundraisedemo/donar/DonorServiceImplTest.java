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
    void createDonorProfileTest() throws DonorExceptions {

        Donor actualDonarVal = new Donor("Asmithaa","asmithaa@gmail.com","string@123");
        Donor actualDonar;
        try {
            actualDonar=(donorService.createDonorProfile(actualDonarVal));
        } catch (DonorExceptions e) {
            throw new RuntimeException(e);
        }

        Assertions.assertNotNull(donorService.viewDonorById(actualDonar.getId()));
        Assertions.assertEquals("Asmithaa",donorService.viewDonorById(actualDonar.getId()).getName());
        Assertions.assertEquals("asmithaa@gmail.com",donorService.viewDonorById(actualDonar.getId()).getEmail());
        Assertions.assertEquals("string@123",donorService.viewDonorById(actualDonar.getId()).getPassword());
        donorRepositoryDao.delete(actualDonar);
    }


    @Test
    void loginDonorTest() throws DonorExceptions {
        Donor actualDonarVal = new Donor("shree","shree@gmail.com","string@800");
        Donor actualDonar = null;
        try {
            actualDonar = donorService.createDonorProfile(actualDonarVal);
        } catch (DonorExceptions e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(donorService.viewDonorById(actualDonar.getId()));
        Assertions.assertEquals(actualDonar.getId(),donorService.loginDonorProfile(actualDonarVal.getEmail(),actualDonar.getPassword()).getId());
        Assertions.assertEquals("shree",donorService.viewDonorById(actualDonar.getId()).getName());
        Assertions.assertEquals("shree@gmail.com",donorService.viewDonorById(actualDonar.getId()).getEmail());
        Assertions.assertEquals("string@800",donorService.viewDonorById(actualDonar.getId()).getPassword());
        donorRepositoryDao.delete(actualDonar);
    }


    @Test
    void viewDonorByIdTest() throws DonorExceptions {
        Donor actualDonarVal = new Donor("shree","shree@gmail.com","string@800");
        Donor actualDonar = null;
        try {
            actualDonar = donorService.createDonorProfile(actualDonarVal);
        } catch (DonorExceptions e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(donorService.viewDonorById(actualDonar.getId()).getId());
        Assertions.assertEquals(actualDonar.getId(),donorService.viewDonorById(actualDonar.getId()).getId());
        Assertions.assertEquals("shree",donorService.viewDonorById(actualDonar.getId()).getName());
        Assertions.assertEquals("shree@gmail.com",donorService.viewDonorById(actualDonar.getId()).getEmail());
        Assertions.assertEquals("string@800",donorService.viewDonorById(actualDonar.getId()).getPassword());
        donorRepositoryDao.delete(actualDonar);
    }

    @Test
    void updateDonorNameByIdTest() throws DonorExceptions {
        Donor actualDonarVal = new Donor("test100","test100@gmail.com","string@6600");
        Donor actualDonar = null;
        try {
            actualDonar = donorService.createDonorProfile(actualDonarVal);
        } catch (DonorExceptions e) {
            throw new RuntimeException(e);
        }
        donorService.updateDonorNameById(actualDonar.getId(),actualDonar.getName());
        Assertions.assertNotNull(donorService.updateDonorNameById(actualDonar.getId(), actualDonar.getName()).getId());
        Assertions.assertEquals("test100",donorService.updateDonorNameById(actualDonar.getId(), actualDonar.getName()).getName());
        Assertions.assertEquals("test100@gmail.com",donorService.updateDonorNameById(actualDonar.getId(), actualDonar.getName()).getEmail());
        Assertions.assertEquals("string@6600",donorService.updateDonorNameById(actualDonar.getId(), actualDonar.getName()).getPassword());
        donorRepositoryDao.delete(actualDonar);
    }


    @Test
    void updateDonorEmailByIdTest() throws DonorExceptions {
        Donor actualDonarVal = new Donor("chann","bonnny@gmail.com","string@6600");
        Donor actualDonar = null;
        try {
            actualDonar = donorService.createDonorProfile(actualDonarVal);
        } catch (DonorExceptions e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(donorService.updateDonorEmailById(actualDonar.getId(), actualDonar.getEmail()).getId());
        Assertions.assertEquals("chann",donorService.updateDonorEmailById(actualDonar.getId(), actualDonar.getEmail()).getName());
        Assertions.assertEquals("bonnny@gmail.com",donorService.updateDonorEmailById(actualDonar.getId(), actualDonar.getEmail()).getEmail());
        Assertions.assertEquals("string@6600",donorService.updateDonorEmailById(actualDonar.getId(), actualDonar.getEmail()).getPassword());
        donorRepositoryDao.delete(actualDonar);
    }




    @Test
    void updateDonorPasswordByIdTest() throws DonorExceptions {
        Donor actualDonarVal = new Donor("channnn","bonnnny@gmail.com","string@6600");
        Donor actualDonar = null;
        try {
            actualDonar = donorService.createDonorProfile(actualDonarVal);
        } catch (DonorExceptions e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(donorService.updateDonorPasswordById(actualDonar.getId(), actualDonar.getEmail()).getId());
        Assertions.assertEquals("channnn",donorService.updateDonorPasswordById(actualDonar.getId(), actualDonar.getPassword()).getName());
        Assertions.assertEquals("bonnnny@gmail.com",donorService.updateDonorPasswordById(actualDonar.getId(), actualDonar.getPassword()).getEmail());
        Assertions.assertEquals("string@6600",donorService.updateDonorPasswordById(actualDonar.getId(), actualDonar.getPassword()).getPassword());
        donorRepositoryDao.delete(actualDonar);
    }

    @Test
    void deleteDonorByIdTest() throws DonorExceptions {
        Donor actualDonarVal = new Donor("channn","bonnnny@gmail.com","string@6600");
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
