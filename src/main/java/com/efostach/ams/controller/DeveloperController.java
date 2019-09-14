package com.efostach.ams.controller;

import com.efostach.ams.model.Developer;
import com.efostach.ams.repository.io.JavaIODeveloperRepositoryImpl;

import java.util.List;

public class DeveloperController {
    private JavaIODeveloperRepositoryImpl ioDevelopers = new JavaIODeveloperRepositoryImpl();

    public List<Developer> showDevelopers() throws Exception {
        List<Developer> listDevelopers = ioDevelopers.getAll();
        if (ioDevelopers.getAll().isEmpty()) {
            throw new Exception("No developers exist.");
        } else
            return listDevelopers;
    }

    public Developer findDeveloperById(Integer id) throws Exception {
        if (id < 0) {
            throw new Exception("Invalid id value.");
        } else {
            Developer result = ioDevelopers.getById(id);
            if (result == null) {
                throw new Exception("Developer not found.");
            } else
                return result;
        }
    }

    public Developer createDeveloper(String firstName, String lastName, String address) throws Exception {
        Developer dev = new Developer();
        dev.setFirstName(firstName);
        dev.setLastName(lastName);
        dev.setAddress(address);

        Developer createdDeveloper = ioDevelopers.create(dev);

        if (createdDeveloper == null) {
            throw new Exception("Developer can't be created.");
        } else {
            return createdDeveloper;
        }
    }

    public void deleteDeveloper(Integer id) throws Exception {
        if (id < 0) {
            throw new Exception("Invalid id value.");
        } else
            ioDevelopers.delete(id);
    }
}
