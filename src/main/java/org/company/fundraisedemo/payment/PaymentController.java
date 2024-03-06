package org.company.fundraisedemo.payment;

import org.company.fundraisedemo.donar.Donor;
import org.company.fundraisedemo.donar.DonorExceptions;
import org.company.fundraisedemo.donar.DonorService;
import org.company.fundraisedemo.post.PostExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController
{

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DonorService donorService;

    @PostMapping("donor/bankDetails/{id}")
    public Donor updateDonorBankDets(@PathVariable Integer id, String accountId, Double balance) throws DonorExceptions {
        return this.donorService.updateDonorBankDets(id, accountId, balance);
    }
    @PatchMapping("payment/transaction")
    public String makePayment(@RequestBody TransactionDto transaction) throws PostExceptions, DonorExceptions, PaymentExceptions {
        return paymentService.transaction(transaction);
    }
}
