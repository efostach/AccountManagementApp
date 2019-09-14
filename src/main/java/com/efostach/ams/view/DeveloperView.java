package com.efostach.ams.view;

import com.efostach.ams.controller.DeveloperController;
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
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void findDeveloperById(String id){
        try {
            printDeveloper(devController.findDeveloperById(Integer.valueOf(id)));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void createDeveloper(String firstName, String lastName, String address){
        try {
            printDeveloper(devController.createDeveloper(firstName, lastName, address));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void deleteDeveloper(String id){
        try {
            devController.deleteDeveloper(Integer.valueOf(id));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void printDeveloper(Developer developer){
        System.out.println("Id: " + developer.getId()
                + "\tName: " + developer.getFirstName() + " " + developer.getLastName()
                + "\tAddress: " + developer.getAddress());
    }
}
