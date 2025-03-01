package com.sandeep.accounts.Service;

import com.sandeep.accounts.DTO.CustomerDto;

public interface IAccountsService {

    void createAccount(CustomerDto customerDto);

    CustomerDto fetchDetails(String mobileNumber);

    Boolean updateAccount(CustomerDto customerDto);

}
