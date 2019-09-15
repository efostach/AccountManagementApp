package com.efostach.ams.controller;

import com.efostach.ams.controller.exceptions.EmptyFileException;
import com.efostach.ams.controller.exceptions.InvalidValueException;
import com.efostach.ams.controller.exceptions.ObjectNotFoundException;
import com.efostach.ams.controller.exceptions.OperationFailException;
import com.efostach.ams.model.Developer;
import com.efostach.ams.repository.io.JavaIODeveloperRepositoryImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class DeveloperController {
    private JavaIODeveloperRepositoryImpl ioDevelopers = new JavaIODeveloperRepositoryImpl();
    //private SkillService skillService = new SkillService();

    public List<Developer> showDevelopers() throws EmptyFileException {
        List<Developer> listDevelopers = null;
        try {
            listDevelopers = ioDevelopers.getAll();
            if (ioDevelopers.getAll().isEmpty())
                throw new EmptyFileException("No developers exist.");
        } catch (FileNotFoundException e) {
            throw new EmptyFileException("No developers exist.");
        }
        return listDevelopers;
    }

    public Developer findDeveloperById(Integer id) throws InvalidValueException, ObjectNotFoundException, OperationFailException {
        if (id < 0) {
            throw new InvalidValueException("Invalid id value.");
        } else {
            Developer result = null;
            try {
                result = ioDevelopers.getById(id);
                if (result == null) {
                    throw new ObjectNotFoundException("Developer not found.");
                }
            } catch (FileNotFoundException e) {
                throw new OperationFailException("Developer failed to be found.");
            }
            return result;
        }

    }

    public Developer createDeveloper(String firstName, String lastName, String address) throws OperationFailException {
        Developer dev = new Developer();
        dev.setFirstName(firstName);
        dev.setLastName(lastName);
        dev.setAddress(address);

        Developer createdDeveloper;
        try {
            createdDeveloper = ioDevelopers.create(dev);
        } catch (IOException e) {
            throw new OperationFailException("Developer failed to be created.");
        }
        return createdDeveloper;
    }

    public void deleteDeveloper(Integer id) throws InvalidValueException, OperationFailException {
        if (id < 0) {
            throw new InvalidValueException("Invalid id value.");
        } else {
            try {
                ioDevelopers.delete(id);
            } catch (FileNotFoundException e) {
                throw new OperationFailException("Developer failed to be deleted.");
            }
        }
    }
}
