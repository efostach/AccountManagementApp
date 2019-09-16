package com.efostach.ams.view;

import com.efostach.ams.controller.AccountController;
import com.efostach.ams.controller.exceptions.EmptyFileException;
import com.efostach.ams.model.Account;

import java.util.Iterator;

public class AccountView {

    private AccountController controller = new AccountController();

    void showAccounts(){
        try {
            Iterator iterator = controller.showDevelopers().iterator();
            while (iterator.hasNext()){
                printAccount((Account) iterator.next());
            }
        } catch (EmptyFileException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void printAccount(Account account){
        System.out.println("Id: " + account.getId()
                + "\tTitle: " + account.getTitle()
                + "\tData: " + account.getData()
                + "\tStatus: " + account.getStatus());
    }
}
