//package org.company.fundraisedemo.payment;
//
//import org.company.fundraisedemo.donar.Donor;
//import org.company.fundraisedemo.donar.DonorExceptions;
//import org.company.fundraisedemo.donar.DonorRepositoryDao;
//import org.company.fundraisedemo.donar.DonorService;
//import org.company.fundraisedemo.fundraiser.Fundraiser;
//import org.company.fundraisedemo.fundraiser.FundraiserRepositoryDao;
//import org.company.fundraisedemo.fundraiser.FundraiserService;
//import org.company.fundraisedemo.fundraiser.FundraiserServiceImplTest;
//import org.company.fundraisedemo.post.Post;
//import org.company.fundraisedemo.post.PostExceptions;
//import org.company.fundraisedemo.post.PostRepositoryDao;
//import org.company.fundraisedemo.post.PostService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class PaymentServiceImplTest {
//
//    @Autowired
//    PostRepositoryDao postRepositoryDao;
//    @Autowired
//    PaymentRepositoryDao paymentRepositoryDao;
//    @Autowired
//    DonorRepositoryDao donorRepositoryDao;
//    @Autowired
//    FundraiserRepositoryDao fundraiserRepositoryDao;
//    @Autowired
//    PostService postService;
//    @Autowired
//    PaymentService paymentService;
//    @Autowired
//    DonorService donorService;
//    @Autowired
//    FundraiserService fundraiserService;
//
//    @Test
//    void transactionTest() {
//        Post post;
//        Donor donor;
//        Fundraiser fundraiser;
//        Payment payment;
//        String paymentStatus = null;
//        Donor donorVal = new Donor("don","don@gmail.com","don","donacc",50000.0);
//        Fundraiser fundraiserVal = new Fundraiser("gon","gon@gmail.com","gon");
//        donor = donorRepositoryDao.save(donorVal);
//        fundraiser = fundraiserRepositoryDao.save(fundraiserVal);
//        Post postVal = new Post("Poverty Help","Expenses for food and shelter for poors for one day","poverty", LocalDate.of(2024, 02, 27),LocalDate.of(2024,04,20),20000.0,0.0,"incomplete",fundraiser);
//        post = postRepositoryDao.save(postVal);
//        TransactionDto transaction = new TransactionDto(donor.getAccountId(),post.getDonationAccountId(),20000.0);
//        try {
//            paymentStatus = paymentService.transaction(transaction);
//        } catch (PaymentExceptions e) {
//            throw new RuntimeException(e);
//        } catch (DonorExceptions e) {
//            throw new RuntimeException(e);
//        } catch (PostExceptions e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            payment = paymentService.findPaymentByDonorsId(donor.getId());
//        } catch (PaymentExceptions e) {
//            throw new RuntimeException(e);
//        }
//
//        Assertions.assertEquals("Success", paymentStatus);
//        Assertions.assertEquals(20000.0, postRepositoryDao.findById(post.getId()).get().getAmountCollected());
//        Assertions.assertEquals(30000.0, donorRepositoryDao.findById(donor.getId()).get().getAccountBalance());
//
//        postRepositoryDao.delete(post);
//        fundraiserRepositoryDao.delete(fundraiser);
//        paymentRepositoryDao.delete(payment);
//        donorRepositoryDao.delete(donor);
//
//
//    }
//
//}