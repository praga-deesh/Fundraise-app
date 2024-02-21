package org.company.fundraisedemo.fundraiser;

import org.company.fundraisedemo.donar.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundraiserServiceImpl implements FundraiserService {

    @Autowired
    private FundraiserRepositoryDao fundraiserRepositoryDao;
    @Override
    public Fundraiser createFunraiser(Fundraiser newFundraiser) {
        return this.fundraiserRepositoryDao.save(newFundraiser);
    }
}
