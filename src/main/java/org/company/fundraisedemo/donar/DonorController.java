package org.company.fundraisedemo.donar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DonorController {
    @Autowired
    private DonorService donorService;

    @PostMapping("donors")
    public Donor createDonor(@RequestBody Donor newDonor) {
        return this.donorService.createDonor(newDonor);

        // abc
    }
}
