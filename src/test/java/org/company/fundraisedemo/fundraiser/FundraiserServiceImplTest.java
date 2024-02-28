package org.company.fundraisedemo.fundraiser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
            e.printStackTrace();
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
            e.printStackTrace();
        }
        expectedFundraiser = fundraiserRepositoryDao.findById(actualFundraiser.getId()).get();
        Assertions.assertEquals(expectedFundraiser.getId(),actualFundraiser.getId());
        fundraiserRepositoryDao.delete(actualFundraiserValue);
    }

//    void updateFundraiserNameByIdTest(){
//        Fundraiser actualFundraiserValue = new Fundraiser("test", "test@gmail.com","test");
//        Fundraiser expectedFundraiser;
//        Fundraiser actualFundraiser = null;
//
//        try{
//            actualFundraiser = fundraiserService.createFundraiserProfile(actualFundraiserValue);
//
//        } catch(FundraiserExceptions e){
//            e.printStackTrace();
//        }
//    }

}
