package org.company.fundraisedemo.fundraiser;

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
    @Override
    public Fundraiser viewFundraiserById(Integer id) throws FundraiserExceptions {
        Optional<Fundraiser> accountOpt=this.fundraiserRepositoryDao.findById(id);
        if(accountOpt.isEmpty())
            throw new FundraiserExceptions("Profile doesn't exists:"+id);
        Fundraiser foundFundraiser=accountOpt.get();
        return foundFundraiser;
    }

    @Override
    public Fundraiser updateFundraiserNameById(Integer id,String newName) throws FundraiserExceptions {
        Optional<Fundraiser> accountOpt=this.fundraiserRepositoryDao.findById(id);
        if(accountOpt.isEmpty())
            throw new FundraiserExceptions("Profile doesn't exists:"+id);
        Fundraiser foundFundraiser=accountOpt.get();
        foundFundraiser.setName(newName);
        this.fundraiserRepositoryDao.save(foundFundraiser);
        return foundFundraiser;
    }

    @Override
    public Fundraiser updateFundraiserEmail(Integer id,String newEmail) throws FundraiserExceptions {
        Optional<Fundraiser> accountOpt=this.fundraiserRepositoryDao.findById(id);
        if(accountOpt.isEmpty())
            throw new FundraiserExceptions("Profile doesn't exists:"+id);
        Fundraiser foundFundraiser=accountOpt.get();
        foundFundraiser.setEmail(newEmail);
        this.fundraiserRepositoryDao.save(foundFundraiser);
        return foundFundraiser;
    }

    @Override
    public Fundraiser updateFundraiserPasswordById(Integer id,String newPassword) throws FundraiserExceptions {
        Optional<Fundraiser> accountOpt=this.fundraiserRepositoryDao.findById(id);
        if(accountOpt.isEmpty())
            throw new FundraiserExceptions("Profile doesn't exists:"+id);
        Fundraiser foundFundraiser=accountOpt.get();
        foundFundraiser.setPassword(newPassword);
        this.fundraiserRepositoryDao.save(foundFundraiser);
        return foundFundraiser;
    }

    @Override
    public String deleteFundraiserById(Integer id) throws FundraiserExceptions {
        Optional<Fundraiser> accountOpt=this.fundraiserRepositoryDao.findById(id);
        if(accountOpt.isEmpty())
            throw new FundraiserExceptions("Profile doesn't exists:"+id);
        this.fundraiserRepositoryDao.deleteById(id);
        return "Profile deleted successfully!!";
    }
}
