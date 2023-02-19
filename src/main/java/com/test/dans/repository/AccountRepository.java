package com.test.dans.repository;

import com.test.dans.pojo.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("SELECT acc FROM Account acc WHERE acc.username = :username")
    Account getByUsername(@Param("username") String username);
}
