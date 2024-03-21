package org.company.fundraisedemo.donar;


import org.company.fundraisedemo.payment.Payment;
import org.company.fundraisedemo.payment.PaymentExceptions;

import java.util.List;

public interface DonorService {

    Donor createDonorProfile(Donor newDonor) throws DonorExceptions;

    Donor getDonorByBankAccountId(String accountId) throws DonorExceptions;

    Donor loginDonorProfile(String email, String password) throws DonorExceptions;

    Donor viewDonorById(Integer id) throws DonorExceptions;

    Donor updateDonorNameById(Integer id,String newName) throws DonorExceptions;

    Donor updateDonorEmailById(Integer id,String newEmail) throws DonorExceptions;

    Donor updateDonorPasswordById(Integer id,String newPassword) throws DonorExceptions;

    String deleteDonorById(Integer id) throws DonorExceptions;

    Donor updateDonorBankDets(Integer id, String accountId, Double balance) throws DonorExceptions;

}
