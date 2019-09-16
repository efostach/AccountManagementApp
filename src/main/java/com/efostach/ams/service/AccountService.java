package com.efostach.ams.service;

import com.efostach.ams.model.Account;
import com.efostach.ams.model.AccountStatus;
import com.efostach.ams.repository.io.JavaIOAccountRepositoryImpl;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AccountService {
    private JavaIOAccountRepositoryImpl ioAccount = new JavaIOAccountRepositoryImpl();

    public Account createAccount(String title, String data) throws IOException {
        Account account = new Account();
        account.setTitle(title);
        account.setData(data);
        account.setStatus(AccountStatus.ACTIVE);

        Account createdAccount;
        createdAccount = ioAccount.create(account);
        return createdAccount;
    }

    protected Account checkIfAccountExist(Integer id) throws FileNotFoundException {
        return ioAccount.getById(id);
    }
}
