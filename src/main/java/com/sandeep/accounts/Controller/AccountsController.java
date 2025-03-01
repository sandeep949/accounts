package com.sandeep.accounts.Controller;

import com.sandeep.accounts.Constants.AccountsConstants;
import com.sandeep.accounts.DTO.CustomerDto;
import com.sandeep.accounts.DTO.ResponseDto;
import com.sandeep.accounts.Service.IAccountsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api" , produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    private IAccountsService iAccountsService;

    public AccountsController(IAccountsService iAccountsService) {
        this.iAccountsService = iAccountsService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {

        iAccountsService.createAccount(customerDto);
        return ResponseEntity.
                status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));

    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchDetails(@RequestParam String mobileNumber) {
        CustomerDto customerDto = iAccountsService.fetchDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }


@GetMapping("/update")
public ResponseEntity<ResponseDto> updateAccountDetails(@RequestBody CustomerDto customerDto){
    boolean isUpdated = iAccountsService.updateAccount(customerDto);
 if(isUpdated){
     return ResponseEntity
             .status(HttpStatus.OK)
             .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
 }else{
     return ResponseEntity
             .status(HttpStatus.INTERNAL_SERVER_ERROR)
             .body(new ResponseDto(AccountsConstants.STATUS_500,AccountsConstants.MESSAGE_500));
 }

    }
}
