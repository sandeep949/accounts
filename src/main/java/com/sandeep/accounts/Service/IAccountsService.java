package com.sandeep.accounts.Service;

import com.sandeep.accounts.DTO.CustomerDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

public interface IAccountsService {

    void createAccount(CustomerDto customerDto);

    CustomerDto fetchDetails(String mobileNumber);

    Boolean updateAccount(CustomerDto customerDto);

    @Transactional
    @Modifying
    boolean deleteAccount(String mobileNumber);


}
