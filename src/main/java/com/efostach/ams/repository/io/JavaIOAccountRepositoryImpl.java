package com.efostach.ams.repository.io;

import com.efostach.ams.model.Account;
import com.efostach.ams.model.AccountStatus;
import com.efostach.ams.repository.AccountRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.efostach.ams.repository.io.IOUtil.*;
import static com.efostach.ams.repository.io.IOUtil.writeDataToFile;

public class JavaIOAccountRepositoryImpl implements AccountRepository {

    private static String file = "src/main/resources/files/account.txt";

    public Account getById(Integer id) throws FileNotFoundException {
        Iterator iterator = stringToAccount().iterator();
        Account result = null;
        while (iterator.hasNext()) {
            Account account = (Account) iterator.next();
            if (id.equals(account.getId())) {
                result = account;
            }
        }
        return result;
    }

    public List<Account> getAll() throws FileNotFoundException {
        return stringToAccount();
    }

    public Account create(Account account) {
        try {
            account.setId(getIncrementedId(file));
            writeDataToFile(file, account.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public Account update(Account account) {
        return null;
    }

    private List<Account> stringToAccount() throws FileNotFoundException {
        List<Account> accountSet = new ArrayList<>();
        Iterator iterator = readDataFromFile(file).iterator();

        while (iterator.hasNext()) {
            String element = (String) iterator.next();
            String[] attributes = element.split(REGEX);

            Account account = new Account();
            account.setId(Integer.valueOf(attributes[0]));
            account.setTitle(attributes[1]);
            account.setData(attributes[2]);
            account.setStatus(AccountStatus.valueOf(attributes[3]));
            accountSet.add(account);
        }
        return accountSet;
    }
}
