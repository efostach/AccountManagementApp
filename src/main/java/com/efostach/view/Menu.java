package main.java.com.efostach.view;

import main.java.com.efostach.model.Account;
import main.java.com.efostach.model.Developer;
import main.java.com.efostach.model.Skill;

import java.util.Iterator;
import java.util.Set;

import static main.java.com.efostach.model.Account.accounts;
import static main.java.com.efostach.model.Developer.developers;

public abstract class Menu {

    public static void printGeneralMenu() {
        System.out.println("\nFor choosing an action, please, enter the number.");
        System.out.println("1. Developer");
        System.out.println("2. Skill");
        System.out.println("3. Exit \n");
    }

    public static void printDeveloperSubGeneralMenu() {
        System.out.println("\nChoose necessary operation:");
        System.out.println("1. Create Developer");
        System.out.println("2. Find Developer");
        System.out.println("3. Edit Developer");
        System.out.println("4. Delete Developer");
        System.out.println("5. Go Back");
        System.out.println("6. Exit \n");
    }

    public static void printEditDeveloperSubMenu() {
        System.out.println("\nChoose necessary operation:");
        System.out.println("1. Edit Skills");
        System.out.println("2. Edit Address");
        System.out.println("3. Edit First Name");
        System.out.println("4. Edit Last Name");
        System.out.println("5. Edit Title");
        System.out.println("6. Edit Data");
        System.out.println("7. Edit Account Status");
        System.out.println("8. Go Back");
        System.out.println("9. Exit \n");
    }

    public static void printEditDeveloperSkillSubMenu() {
        System.out.println("\nChoose necessary operation:");
        System.out.println("1. Add Skill");
        System.out.println("2. Delete Skill");
        System.out.println("3. Go Back");
        System.out.println("4. Exit \n");
    }

    public static void printSkillSubGeneralMenu() {
        System.out.println("\nChoose necessary operation:");
        System.out.println("1. Create Skill");
        System.out.println("2. List Skill");
        System.out.println("3. Go Back");
        System.out.println("4. Exit \n");
    }


    public static void printInputParameter(String name) {
        System.out.println("\nEnter " + name + ":");
    }

    public static void printInputParametersToCreateDeveloper(){
        System.out.println("\nEnter First Name, Last Name, Address, Title, Data:");
    }

    public static void printCreatedSkill(Skill skill) {
        System.out.println("Skill '" + skill.getName() + "' successfully created with ID = " + skill.getID());
    }


    public static void printWrongSelection(){
        System.out.println("Oops, it's wrong value.\n");
    }

    public static void printAccountStatus(){
        System.out.println("1 - ACTIVE, 2 - BANNED, 3 - DELETED");
    }

    public static void printCreatedDeveloper(Developer dev) {
        System.out.println("Developer '" + dev.getFullName() + "' successfully created with ID = " + dev.getID());
    }

    public static void printRemovedObject(){
        System.out.println("Element successfully removed.");
    }

    public static void printElements(Set elements){
        if(!elements.isEmpty()) {
            elements.forEach(System.out::println);
        } else
            System.out.println("No object exists.");
    }

    public static void printElements(){
        if(!developers.isEmpty() && !accounts.isEmpty()) {
            Iterator first = developers.iterator();

            Developer dev;
            Account acc;

            while (first.hasNext()) {
                dev = (Developer) first.next();

                Iterator second = accounts.iterator();
                while (second.hasNext()) {
                    acc = (Account) second.next();
                    if (dev.getID().equals(acc.getID())) {
                        System.out.print(dev.toString() + "\tTitle: " + acc.getTitle() + "\tStatus: " + acc.getStatus());
                    }
                }
            }

        } else
            System.out.println("No object exists.");
    }

    public static void printSearchResult(Boolean result){
        if (result){
            System.out.println("Object exists.");
        } else
            System.out.println("Object doesn't exist.");
    }

    public static void printNoElementsExist(String elementName){
        System.out.println("No " + elementName + " exists.");
    }

    public static void printNotFoundElement(String elementName){
        System.out.println(elementName + " not found.");
    }
}
