package com.test.dans.controller;

import com.test.dans.model.response.BaseResponse;
import com.test.dans.pojo.Account;
import com.test.dans.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;

    @PostMapping("/register-account")
    public BaseResponse<Account> createAccount(@RequestBody Account account){
        try {
            accountService.saveAccount(account);
            return new BaseResponse<Account>("Account Created", HttpStatus.CREATED.value(), account);
        } catch (Exception e) {
            return new BaseResponse<Account>("Account Created", HttpStatus.BAD_REQUEST.value(), account);
        }

    }
}
