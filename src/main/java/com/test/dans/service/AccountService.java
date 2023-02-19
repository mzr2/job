package com.test.dans.service;

import com.test.dans.pojo.Account;

public interface AccountService {
    Account getAccount(String username);
    Account saveAccount(Account account);
}
