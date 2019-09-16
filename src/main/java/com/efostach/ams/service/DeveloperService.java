package com.efostach.ams.service;

import com.efostach.ams.controller.exceptions.OperationFailException;
import com.efostach.ams.model.Account;
import com.efostach.ams.model.Developer;
import com.efostach.ams.model.Skill;
import com.efostach.ams.repository.io.JavaIODeveloperRepositoryImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DeveloperService {

    public Developer createDeveloper(String firstName, String lastName, String address, String title, String data, Set<Integer> skillIds) throws OperationFailException, IOException {

        JavaIODeveloperRepositoryImpl ioDevelopers = new JavaIODeveloperRepositoryImpl();
        AccountService accountService = new AccountService();

        Developer dev = new Developer();
        dev.setFirstName(firstName);
        dev.setLastName(lastName);
        dev.setAddress(address);
        addSkillToDeveloper(dev, skillIds);
        addAccountToDeveloper(dev, accountService.createAccount(title, data));

        Developer createdDeveloper = ioDevelopers.create(dev);

        return createdDeveloper;
    }

    public void addAccountToDeveloper(Developer developer, Account account) throws FileNotFoundException {
        AccountService accountService = new AccountService();
        Integer id = account.getId();
        if (accountService.checkIfAccountExist(id) != null) {
            developer.setAccountId(id);
        }
    }

    public Set<Integer> addSkillToDeveloper(Developer developer, Set<Integer> ids) throws FileNotFoundException {
        SkillService skillService = new SkillService();
        Set<Integer> missingSkills = new HashSet<>();
        Integer skillId;
        Skill skill;
        Iterator iterator = ids.iterator();
        while(iterator.hasNext()){
            skill = skillService.checkIfSkillExist((Integer) iterator.next());
            if (skill != null) {
                skillId = skill.getId();
                developer.setSkill(skillId);
                missingSkills.add(skillId);
            }
        }
        return missingSkills;
    }

    protected Set<Developer> findDevelopersBySkill(Integer skillId) throws FileNotFoundException {
        JavaIODeveloperRepositoryImpl ioDev = new JavaIODeveloperRepositoryImpl();
        Set<Developer> devSet = new HashSet<>();
        Developer dev;
        Iterator iterator = ioDev.getAll().iterator();
        while (iterator.hasNext()) {
            dev = (Developer) iterator.next();
            if (dev.getSkillSet().contains(skillId)) {
                devSet.add(dev);
            }
        }
        return devSet;
    }
}
