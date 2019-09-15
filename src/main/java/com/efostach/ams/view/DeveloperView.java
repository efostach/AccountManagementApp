package com.efostach.ams.view;

import com.efostach.ams.controller.DeveloperController;
import com.efostach.ams.controller.exceptions.EmptyFileException;
import com.efostach.ams.controller.exceptions.InvalidValueException;
import com.efostach.ams.controller.exceptions.ObjectNotFoundException;
import com.efostach.ams.controller.exceptions.OperationFailException;
import com.efostach.ams.model.Developer;

import java.util.Iterator;

public class DeveloperView {

    private DeveloperController devController = new DeveloperController();

    void showDevelopers(){
        try {
            Iterator iterator = devController.showDevelopers().iterator();
            while (iterator.hasNext()){
                printDeveloper((Developer) iterator.next());
            }
        } catch (EmptyFileException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void findDeveloperById(String id){
        try {
            printDeveloper(devController.findDeveloperById(Integer.valueOf(id)));
        } catch (InvalidValueException | OperationFailException | ObjectNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void createDeveloper(String firstName, String lastName, String address){
        try {
            printDeveloper(devController.createDeveloper(firstName, lastName, address));
        } catch (OperationFailException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void deleteDeveloper(String id){
        try {
            devController.deleteDeveloper(Integer.valueOf(id));
        } catch (InvalidValueException | OperationFailException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void printDeveloper(Developer developer){
        System.out.println("Id: " + developer.getId()
                + "\tName: " + developer.getFirstName() + " " + developer.getLastName()
                + "\tAddress: " + developer.getAddress()
                + "\t Skills: " + developer.getSkillSet());
    }
}
