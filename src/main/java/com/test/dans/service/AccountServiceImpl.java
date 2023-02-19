package com.test.dans.service;

import com.test.dans.pojo.Account;
import com.test.dans.repository.AccountRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Account getAccount(String username){
        Account user = accountRepository.getByUsername(username);
        return user;
    }

    @Override
    public Account saveAccount(Account account) {
//        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }
}
