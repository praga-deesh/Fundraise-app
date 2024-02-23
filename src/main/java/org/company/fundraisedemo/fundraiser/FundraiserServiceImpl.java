package org.company.fundraisedemo.fundraiser;

import org.company.fundraisedemo.donar.Donor;
import org.company.fundraisedemo.donar.DonorExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FundraiserServiceImpl implements FundraiserService {

    @Autowired
    private FundraiserRepositoryDao fundraiserRepositoryDao;

    @Override
    public Fundraiser createFundraiserProfile(Fundraiser newFundraiser) throws FundraiserExceptions {
        Optional<Fundraiser> accountOpt=this.fundraiserRepositoryDao.findByEmail(newFundraiser.getEmail());
        if(accountOpt.isPresent())
            throw new FundraiserExceptions("Account already exits..so try logging in");
        return this.fundraiserRepositoryDao.save(newFundraiser);
    }

    @Override
    public Fundraiser loginFundraiserProfile(String userEmail, String userPassword) throws FundraiserExceptions {
        Optional<Fundraiser> accountOpt=this.fundraiserRepositoryDao.findByEmail(userEmail);
        if(accountOpt.isEmpty())
            throw new FundraiserExceptions("Account doesn't exits:"+userEmail);
        Fundraiser foundFundraiser=accountOpt.get();
        if(!foundFundraiser.getPassword().equals(userPassword))
            throw new FundraiserExceptions("Password doesn't match");
        return foundFundraiser;
    }
}
