package org.company.fundraisedemo.fundraiser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class FundraiserServiceImplTest {

    @Autowired
    FundraiserService fundraiserService;
    @Autowired
    FundraiserRepositoryDao fundraiserRepositoryDao;


    @Test
    void createFundraiserProfileNotNullTest(){
        Fundraiser actualFundraiserValue = new Fundraiser("test", "test@gmail.com", "test");
        Fundraiser expectedFundraiser;
        Fundraiser actualFundraiser = null;
        try{
            actualFundraiser = fundraiserService.createFundraiserProfile(actualFundraiserValue);
        }catch(FundraiserExceptions e){
            throw new RuntimeException(e);
        }
        expectedFundraiser = fundraiserRepositoryDao.findById(actualFundraiser.getId()).get();
        Assertions.assertEquals(expectedFundraiser.getId(), actualFundraiser.getId());
        fundraiserRepositoryDao.delete(actualFundraiser);
    }

    @Test
    void viewFundraiserByIdTest(){
        Fundraiser actualFundraiserValue = new Fundraiser("test", "test@gmail.com","test");
        Fundraiser expectedFundraiser;
        Fundraiser actualFundraiser = null;

        try{
            actualFundraiser = fundraiserService.createFundraiserProfile(actualFundraiserValue);
        } catch(FundraiserExceptions e){
            throw new RuntimeException(e);
        }
        expectedFundraiser = fundraiserRepositoryDao.findById(actualFundraiser.getId()).get();
        Assertions.assertEquals(expectedFundraiser.getId(),actualFundraiser.getId());
        fundraiserRepositoryDao.delete(actualFundraiserValue);
    }

    // Access the fundraiser with the help of id and then update the name
    @Test
    void updateFundraiserNameByIdTest() throws FundraiserExceptions {
        Fundraiser actualFundraiserValue = new Fundraiser("test", "test@gmail.com","test");
        Fundraiser expectedFundraiser;
        Fundraiser actualFundraiser = null;

        try{
            actualFundraiser = fundraiserService.createFundraiserProfile(actualFundraiserValue);
        } catch(FundraiserExceptions e){
            throw new RuntimeException(e);
        }
        String newName = "updatedName";
        Fundraiser updatedName = fundraiserService.updateFundraiserNameById(actualFundraiser.getId(),newName);
        expectedFundraiser = fundraiserRepositoryDao.findById(actualFundraiser.getId()).get();
        Assertions.assertEquals(expectedFundraiser.getName(), updatedName.getName());
        fundraiserRepositoryDao.delete(actualFundraiserValue);
    }
    @Test
    void loginFundraiserTest()
    {
        Fundraiser actualFundraiserVal = new Fundraiser("test","test@gmail.com","test");
        Fundraiser expectedFundraiser;
        Fundraiser actualFundraiser = null;
        try {
            actualFundraiser = fundraiserService.createFundraiserProfile(actualFundraiserVal);
        } catch (FundraiserExceptions e) {
            throw new RuntimeException(e);
        }
        expectedFundraiser=fundraiserRepositoryDao.findById(actualFundraiser.getId()).get();
        Assertions.assertEquals(expectedFundraiser.getEmail(),actualFundraiser.getEmail());
        Assertions.assertEquals(expectedFundraiser.getPassword(),actualFundraiser.getPassword());
        fundraiserRepositoryDao.delete(actualFundraiser);
    }

    @Test
    void updateFundraiserEmailByIdTest() throws FundraiserExceptions {
        Fundraiser actualFundraiserValue = new Fundraiser("test", "test@gmail.com","test");
        Fundraiser expectedFundraiser;
        Fundraiser actualFundraiser = null;

        try{
            actualFundraiser = fundraiserService.createFundraiserProfile(actualFundraiserValue);
        } catch(FundraiserExceptions e){
            throw new RuntimeException(e);
        }
        String newEmail = "updatedEmail@gmail.com";
        Fundraiser updatedEmail = fundraiserService.updateFundraiserEmail(actualFundraiser.getId(),newEmail);
        expectedFundraiser = fundraiserRepositoryDao.findById(actualFundraiser.getId()).get();
        Assertions.assertEquals(expectedFundraiser.getEmail(), updatedEmail.getEmail());
        fundraiserRepositoryDao.delete(actualFundraiserValue);
    }
    @Test
    void updateFundraiserPasswordByIdTest() throws FundraiserExceptions{
        Fundraiser actualFundraiserValue = new Fundraiser("test", "test@gmail.com","test");
        Fundraiser expectedFundraiser;
        Fundraiser actualFundraiser = null;

        try{
            actualFundraiser = fundraiserService.createFundraiserProfile(actualFundraiserValue);
        } catch(FundraiserExceptions e){
            throw new RuntimeException(e);
        }
        String newPassword = "updatedPassword";
        Fundraiser updatedPassword = fundraiserService.updateFundraiserPasswordById(actualFundraiser.getId(),newPassword);
        expectedFundraiser = fundraiserRepositoryDao.findById(actualFundraiser.getId()).get();
        Assertions.assertEquals(expectedFundraiser.getPassword(), updatedPassword.getPassword());
        fundraiserRepositoryDao.delete(actualFundraiserValue);
    }
    @Test
    void deleteFundraiserByIdTest() throws FundraiserExceptions {
        Fundraiser actualFundraiserValue = new Fundraiser("test", "test@gmail.com","test");
        Fundraiser actualFundraiser = null;

        try{
            actualFundraiser = fundraiserService.createFundraiserProfile(actualFundraiserValue);
        } catch(FundraiserExceptions e){
            throw new RuntimeException(e);
        }

        fundraiserRepositoryDao.findById(actualFundraiser.getId()).get();
        fundraiserService.deleteFundraiserById(actualFundraiser.getId());

        Fundraiser finalActualFundraiser = actualFundraiser;
        //assertThrows(), which allows us to test multiple exceptions within the same test
        assertThrows(FundraiserExceptions.class, () -> {
            fundraiserService.deleteFundraiserById(finalActualFundraiser.getId());
        });
    }
}


