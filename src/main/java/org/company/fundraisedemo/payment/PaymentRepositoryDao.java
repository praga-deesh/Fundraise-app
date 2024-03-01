package org.company.fundraisedemo.payment;

import org.company.fundraisedemo.donar.Donor;
import org.company.fundraisedemo.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepositoryDao extends JpaRepository<Payment,Integer> {

    Payment findPaymentByDonorsId(Integer donorId);
//    Payment findPaymentByDonationPostId(Integer donationPostId);

}
