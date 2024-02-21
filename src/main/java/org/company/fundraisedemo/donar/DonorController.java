package org.company.fundraisedemo.donar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class DonorController {
    @Autowired
    private DonorService donorService;
//hellohi
    @PostMapping("donor/createNewProfile")
    public Donor createDonor(@RequestBody Donor newDonor) throws DonorExceptions {
        return this.donorService.createDonorProfile(newDonor);
    }
    @PostMapping("donor/login")
    public Donor loginDonor(@RequestBody DonorLoginDto donorLoginDto) throws DonorExceptions {
        return this.donorService.loginDonorProfile(donorLoginDto.getEmail(),donorLoginDto.getPassword());
    }
    @GetMapping("donor")
    public Donor viewDonor(Integer id) throws DonorExceptions {
        return this.donorService.viewDonorById(id);
    }
    @PatchMapping("donor/updateName")
    public Donor updateDonorName(Integer id,String newName) throws DonorExceptions {
        return this.donorService.updateDonorNameById(id,newName);
    }

    @PatchMapping("donor/updateEmail")
    public Donor updateDonorEmail(Integer id,String newEmail) throws DonorExceptions {
        return this.donorService.updateDonorEmail(id,newEmail);
    }

    @PatchMapping("donor/updatePassword")
    public Donor updateDonorPassword(Integer id,@RequestBody DonorLoginDto donorLoginDto) throws DonorExceptions {
        return this.donorService.updateDonorPasswordById(id,donorLoginDto.getPassword());
    }

    @DeleteMapping("donor/delete")
    public String deleteDonor(Integer id) throws DonorExceptions {
        return this.donorService.deleteDonorById(id);
    }

//    @GetMapping("donar/posts")
//    public void viewPosts()
//    {
//        return
//    }
//
//    @PostMapping("donor/donate")
//    public void donate()
//{
//
//}
//    @GetMapping("donor/donationHistory")
//    public List<Double> viewDonationHistoryById(Integer id)
//    {
//        return this.donorService.viewDonationHistoryById(id);
//    }
}
