package org.company.fundraisedemo.donar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DonorServiceImpl implements DonorService
{

    @Autowired
    private DonorRepositoryDao donorRepositoryDao;

    @Override
    public Donor createDonorProfile(Donor newDonor) throws DonorExceptions {

        Optional<Donor> accountOpt=this.donorRepositoryDao.findByEmail(newDonor.getEmail());
        if(accountOpt.isPresent())
            throw new DonorExceptions("Account already exits..so try logging in");
        return this.donorRepositoryDao.save(newDonor);
    }

    @Override
    public Donor loginDonorProfile(String userEmail, String userPassword) throws DonorExceptions {
        Optional<Donor> accoutOpt=this.donorRepositoryDao.findByEmail(userEmail);
        if(accoutOpt.isEmpty())
            throw new DonorExceptions("Account doesn't exits:"+userEmail);
        Donor foundDonor=accoutOpt.get();
        if(!foundDonor.getPassword().equals(userPassword))
            throw new DonorExceptions("Password doesn't match");
        return foundDonor;
    }

    @Override
    public Donor viewDonorById(Integer id) throws DonorExceptions {
        if(id==null)
            throw new DonorExceptions("Id should not be null");
        Optional<Donor> accountOpt=this.donorRepositoryDao.findById(id);
        if(accountOpt.isEmpty())
            throw new DonorExceptions("Profile doesn't exists:"+id);
        Donor foundDonor=accountOpt.get();
        return foundDonor;
    }

    @Override
    public Donor updateDonorNameById(Integer id,String newName) throws DonorExceptions {
        Optional<Donor> accountOpt=this.donorRepositoryDao.findById(id);
        if(accountOpt.isEmpty())
            throw new DonorExceptions("Profile doesn't exists:"+id);
        Donor foundDonor=accountOpt.get();
        foundDonor.setName(newName);
        this.donorRepositoryDao.save(foundDonor);
        return foundDonor;
    }

    @Override
    public Donor updateDonorEmailById(Integer id,String newEmail) throws DonorExceptions {
        Optional<Donor> accountOpt=this.donorRepositoryDao.findById(id);
        if(accountOpt.isEmpty())
            throw new DonorExceptions("Profile doesn't exists:"+id);
        Donor foundDonor=accountOpt.get();
        foundDonor.setEmail(newEmail);
        this.donorRepositoryDao.save(foundDonor);
        return foundDonor;
    }

    @Override
    public Donor updateDonorPasswordById(Integer id,String newPassword) throws DonorExceptions {
        Optional<Donor> accountOpt=this.donorRepositoryDao.findById(id);
        if(accountOpt.isEmpty())
            throw new DonorExceptions("Profile doesn't exists:"+id);
        Donor foundDonor=accountOpt.get();
        foundDonor.setPassword(newPassword);
        this.donorRepositoryDao.save(foundDonor);
        return foundDonor;
    }

    @Override
    public String deleteDonorById(Integer id) throws DonorExceptions {
        Optional<Donor> accountOpt=this.donorRepositoryDao.findById(id);
        if(accountOpt.isEmpty())
            throw new DonorExceptions("Profile doesn't exists:"+id);
        this.donorRepositoryDao.deleteById(id);
        return "Profile deleted successfully!!";
    }

}
