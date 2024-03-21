package org.company.fundraisedemo.payment;

import org.company.fundraisedemo.donar.DonorExceptions;
import org.company.fundraisedemo.post.PostExceptions;

import java.util.List;

public interface PaymentService {
     Payment transaction(TransactionDto transaction) throws PaymentExceptions,DonorExceptions, PostExceptions;

    public List<Payment> viewDonationsByDonorId(Integer donorId) throws PaymentExceptions;
    //    List<Payment> findPaymentByDonorsId(Integer donorId) throws PaymentExceptions;
    List<Payment> findPaymentByDonationPostId(Integer donationPostId) throws PaymentExceptions;
}

