package org.company.fundraisedemo.payment;

import org.company.fundraisedemo.donar.Donor;
import org.company.fundraisedemo.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepositoryDao extends JpaRepository<Payment,Integer> {

//    List<Payment> findPaymentByDonorsId(Integer donorId);
//    List<Payment> findPaymentByDonationPostId(Integer donationPostId);

}
