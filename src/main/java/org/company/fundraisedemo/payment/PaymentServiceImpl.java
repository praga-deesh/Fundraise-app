package org.company.fundraisedemo.payment;

import org.company.fundraisedemo.donar.Donor;
import org.company.fundraisedemo.donar.DonorExceptions;
import org.company.fundraisedemo.donar.DonorRepositoryDao;
import org.company.fundraisedemo.donar.DonorService;
import org.company.fundraisedemo.post.Post;
import org.company.fundraisedemo.post.PostExceptions;
import org.company.fundraisedemo.post.PostRepositoryDao;
import org.company.fundraisedemo.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    DonorRepositoryDao donorRepositoryDao;
    @Autowired
    DonorService donorService;
    @Autowired
    PostRepositoryDao postRepositoryDao;
    @Autowired
    PostService postService;
    @Autowired
    PaymentRepositoryDao paymentRepositoryDao;

    @Override
    public Payment transaction(TransactionDto transaction) throws PaymentExceptions,DonorExceptions, PostExceptions {

        Donor fromAccount = donorService.getDonorByBankAccountId(transaction.getSenderId());
        Post toAccount = postService.getPostByAccountId(transaction.getReceiverId());
        Double transferAmount = transaction.getAmount();
        System.out.println(fromAccount);
        System.out.println(toAccount);

        if(toAccount.getStatus().equalsIgnoreCase("complete"))
            throw new PaymentExceptions("The donation Post has recieved the Target Donation Amount");
        if(transferAmount > (toAccount.getAmountRequested()-toAccount.getAmountCollected()))
            throw new PaymentExceptions("The donation Amount is Exceeding the Target Amount");
        if(transferAmount > fromAccount.getAccountBalance())
            throw new PaymentExceptions("Insufficient Balance !!!");

        fromAccount.setAccountBalance(fromAccount.getAccountBalance() - transferAmount);
        //toAccount.setDonationAccountBalance(toAccount.getDonationAccountBalance()+transaction.getAmount());
        toAccount.setAmountCollected(toAccount.getAmountCollected()+transaction.getAmount());
        donorRepositoryDao.save(fromAccount);
        postRepositoryDao.save(toAccount);
        Payment newPayment = new Payment(fromAccount.getAccountId(), toAccount.getDonationAccountId(),toAccount.getId(),transferAmount, LocalDateTime.now(),"Success", fromAccount);
        paymentRepositoryDao.save(newPayment);
        if(newPayment.getStatus().equalsIgnoreCase("Success"))
            if(toAccount.getAmountCollected().equals(toAccount.getAmountRequested()))
                toAccount.setStatus("completed");
        postRepositoryDao.save(toAccount);
        return newPayment;
    }

    @Override
    public List<Payment> viewDonationsByDonorId(Integer donorId) throws PaymentExceptions {
        List<Payment> paymentList = this.paymentRepositoryDao.findAll();
        paymentList = paymentList.stream().filter((p)->p.getDonors().getId().equals(donorId)).toList();
        if(paymentList.isEmpty()) {
            throw new PaymentExceptions("No Donations by this user");
        }
        return paymentList;
    }


    @Override
    public List<Payment> findPaymentByDonationPostId(Integer donationPostId) throws PaymentExceptions {
        List<Payment> paymentList= this.paymentRepositoryDao.findAll();
        paymentList = paymentList.stream().filter((p)->p.getDonatedPostId().equals(donationPostId)).toList();
        if(paymentList.isEmpty()) {
            throw new PaymentExceptions("No Donations in this post");
        }
        return paymentList;
    }

//    @Override
//    public Payment findPaymentByDonationPostId(Integer donationPostId) throws PaymentExceptions {
//        return this.paymentRepositoryDao.findPaymentByDonationPostId(donationPostId);
//    }
}
