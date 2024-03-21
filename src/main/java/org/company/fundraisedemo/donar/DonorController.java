package org.company.fundraisedemo.donar;


import org.company.fundraisedemo.payment.Payment;
import org.company.fundraisedemo.payment.PaymentExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
public class DonorController {

    @Autowired
    private DonorService donorService;


    @PostMapping("donor")
    public Donor createDonor(@RequestBody Donor newDonor) throws DonorExceptions {
        return this.donorService.createDonorProfile(newDonor);
    }


    @PostMapping("donor/login")
    public Donor loginDonor(@RequestBody DonorLoginDto donorLoginDto) throws DonorExceptions {
        return this.donorService.loginDonorProfile(donorLoginDto.getEmail(), donorLoginDto.getPassword());
    }


    @GetMapping("donor/{id}")
    public Donor viewDonor(Integer id) throws DonorExceptions {
        return this.donorService.viewDonorById(id);
    }

    @PatchMapping("donor/name")
    public Donor updateDonorName(Integer id, String newName) throws DonorExceptions {
        return this.donorService.updateDonorNameById(id, newName);
    }

    @PatchMapping("donor/email")
    public Donor updateDonorEmail(Integer id, String newEmail) throws DonorExceptions {
        return this.donorService.updateDonorEmailById(id, newEmail);
    }

    @PatchMapping("donor/password")
    public Donor updateDonorPassword(Integer id, @RequestBody DonorLoginDto donorLoginDto) throws DonorExceptions {
        return this.donorService.updateDonorPasswordById(id, donorLoginDto.getPassword());
    }

    @DeleteMapping("donor")
    public String deleteDonor(Integer id) throws DonorExceptions {
        return this.donorService.deleteDonorById(id);
    }


}

