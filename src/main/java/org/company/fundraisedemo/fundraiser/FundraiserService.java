package org.company.fundraisedemo.fundraiser;


public interface FundraiserService {
    Fundraiser createFundraiserProfile(Fundraiser newFundraiser) throws FundraiserExceptions;
    Fundraiser loginFundraiserProfile(String email, String password) throws FundraiserExceptions;
}
