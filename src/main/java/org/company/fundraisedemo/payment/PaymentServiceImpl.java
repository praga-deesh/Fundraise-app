package org.company.fundraisedemo.payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentServiceImpl {

    @Override
    public List<TransactionDto> transferAmount(Integer id, Integer donorId, Integer postId, Integer amount, Integer fromDonorId, Integer toFundRaiserId) throws PaymentExceptions {
//        Optional<Account> fromAccountOpt=this.accountRepository.findById(fromId);
//        Optional<Account> toAccountOpt=this.accountRepository.findById(toId);
//        if(!fromAccountOpt.isPresent() ||!toAccountOpt.isPresent())
//            throw new AccountException("Account doesn't exits");
//        Account fromAccount=fromAccountOpt.get();
//        if(fromAccount.getAmount()<amount)
//            throw new AccountException("Insufficient amount");
//        Account toAccount=toAccountOpt.get();
//        fromAccount.setAmount(fromAccount.getAmount()-amount);
//        toAccount.setAmount(toAccount.getAmount()+amount);
//        this.accountRepository.save(fromAccount);
//        this.accountRepository.save(toAccount);
//        List<Account>  list = new ArrayList<>();
//        list.add(fromAccount);
//        list.add(toAccount);
//        return list;
    }
}
