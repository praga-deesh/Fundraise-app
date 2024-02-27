package org.company.fundraisedemo.fundraiser;


public interface FundraiserService {
    Fundraiser createFundraiserProfile(Fundraiser newFundraiser) throws FundraiserExceptions;
    Fundraiser loginFundraiserProfile(String email, String password) throws FundraiserExceptions;
    Fundraiser viewFundraiserById(Integer id) throws FundraiserExceptions;
    Fundraiser updateFundraiserNameById(Integer id,String newName) throws FundraiserExceptions;
    Fundraiser updateFundraiserEmail(Integer id,String newEmail) throws FundraiserExceptions;
    Fundraiser updateFundraiserPasswordById(Integer id,String newPassword) throws FundraiserExceptions;
    String deleteFundraiserById(Integer id) throws FundraiserExceptions;
}
