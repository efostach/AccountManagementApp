package main.java.com.efostach.repository;

import main.java.com.efostach.model.Account;

import java.util.Set;

public interface AccountRepository extends GenericRepository<Account, Integer>{
    void writeDataToFile(Set<Account> accounts);

}
