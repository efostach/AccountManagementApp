package main.java.com.efostach.repository;

import main.java.com.efostach.model.Account;

import java.io.*;
import java.util.Set;

public class JavaIOAccountRepository implements AccountRepository{

    private File file = new File ("account.txt");

    public void writeDataToFile(Set<Account> accounts) {
        try (FileOutputStream out = new FileOutputStream(file)){
            ObjectOutputStream ous = new ObjectOutputStream(out);
            ous.writeObject(accounts.toString());
        } catch (IOException e){
            System.out.println("The file can't be closed. \n" + e);
        }
    }
}
