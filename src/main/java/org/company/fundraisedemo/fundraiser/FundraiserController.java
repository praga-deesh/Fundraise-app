package org.company.fundraisedemo.fundraiser;

import org.company.fundraisedemo.donar.Donor;
import org.company.fundraisedemo.donar.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundraiserController {

    @Autowired
    private FundraiserService fundraiserService;

    @PostMapping("fundraisers")
    public Fundraiser createFundraiser(@RequestBody Fundraiser newFundraiser ) {
        return this.fundraiserService.createFunraiser(newFundraiser);
    }
}
