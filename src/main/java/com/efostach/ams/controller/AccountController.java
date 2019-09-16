package com.efostach.ams.controller;

import com.efostach.ams.controller.exceptions.EmptyFileException;
import com.efostach.ams.model.Account;
import com.efostach.ams.repository.io.JavaIOAccountRepositoryImpl;

import java.io.FileNotFoundException;
import java.util.List;

public class AccountController {

    public List<Account> showDevelopers() throws EmptyFileException {

        JavaIOAccountRepositoryImpl ioAccount = new JavaIOAccountRepositoryImpl();

        List<Account> listDevelopers;
        try {
            listDevelopers = ioAccount.getAll();
            if (ioAccount.getAll().isEmpty())
                throw new EmptyFileException("No accounts exist.");
        } catch (FileNotFoundException e) {
            throw new EmptyFileException("No accounts exist.");
        }
        return listDevelopers;
    }
}
