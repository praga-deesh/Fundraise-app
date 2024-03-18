package org.company.fundraisedemo.payment;

import org.company.fundraisedemo.donar.DonorExceptions;
import org.company.fundraisedemo.post.PostExceptions;

public interface PaymentService {
     Payment transaction(TransactionDto transaction) throws PaymentExceptions,DonorExceptions, PostExceptions;

    Payment findPaymentByDonorsId(Integer donorId) throws PaymentExceptions;
    Payment findPaymentByDonationPostId(Integer donationPostId) throws PaymentExceptions;
}

