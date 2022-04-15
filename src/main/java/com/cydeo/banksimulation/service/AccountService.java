package com.cydeo.banksimulation.service;


import com.cydeo.banksimulation.enums.AccountStatus;
import com.cydeo.banksimulation.enums.AccountType;
import com.cydeo.banksimulation.model.Account;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface AccountService {
    Account createNewAccount(BigDecimal balance, AccountStatus accountStatus, Date creationDate, AccountType accountType, long userId);

    List<Account> listAllAccount ();

    void deleteAccount(UUID account);

    Account retriverById(UUID account);
}
