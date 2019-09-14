package com.efostach.ams.view;

import java.util.Scanner;

public class AppConsole {
    AccountView aw = new AccountView();
    DeveloperView dw = new DeveloperView();
    SkillView sw = new SkillView();

    Scanner scanner = new Scanner(System.in);

    public static void printGeneralMenu() {
        System.out.println("\nFor choosing an action, please, enter the number.");
        System.out.println("1. Developers");
        System.out.println("2. Skills");
        System.out.println("3. Exit \n");
    }

    public static void printDeveloperSubGeneralMenu() {
        System.out.println("\nChoose necessary operation:");
        System.out.println("1. Show All Developers");
        System.out.println("2. Create Developer");
        System.out.println("3. Find Developer");
        System.out.println("4. Delete Developer");
        System.out.println("5. Go Back\n");
    }

    public static void printEditDeveloperSubMenu() {
        System.out.println("\nChoose necessary operation:");
        System.out.println("1. Update Skills");
        System.out.println("2. Update Address");
        System.out.println("3. Update First Name");
        System.out.println("4. Update Last Name");
        System.out.println("5. Update Title");
        System.out.println("6. Update Data");
        System.out.println("7. Update Account Status");
        System.out.println("8. Go Back\n");
    }

    public static void printEditDeveloperSkillSubMenu() {
        System.out.println("\nChoose necessary operation:");
        System.out.println("1. Assign Skill to Developer");
        System.out.println("2. Remove Skill from Developer");
        System.out.println("3. Go Back\n");
    }

    public static void printSkillSubGeneralMenu() {
        System.out.println("\nChoose necessary operation:");
        System.out.println("1. Show All Skills");
        System.out.println("2. Create Skill");
        System.out.println("3. Find Skill");
        System.out.println("4. Delete Skill");
        System.out.println("5. Go Back\n");
    }

    public static void printWrongSelection(){
        System.out.println("Oops, it's wrong value.\n");
    }

    public static void printInputParameter(String name) {
        System.out.println("\nEnter " + name + ":");
    }

    public void run(){
        printGeneralMenu();

        switch (scanner.nextLine()){
            default: {
                printWrongSelection();
                run();
                break;
            }
            case "1": {
                printDeveloperSubGeneralMenu();
                goToDeveloperSubGeneralMenu();
                break;
            }
            case "2": {
                printSkillSubGeneralMenu();
                goToSkillSubGeneralMenu();
                break;
            }
            case "3": {
                break;
            }
        }
    }

    private void goToDeveloperSubGeneralMenu() {
        switch (scanner.nextLine()) {
            default: {
                printWrongSelection();
                run();
                break;
            }
            case "1": {
                dw.showDevelopers();
                run();
                break;
            }
            case "2": {
                printInputParameter("First Name, Last Name, Address");
                dw.createDeveloper(scanner.nextLine(),
                        scanner.nextLine(),
                        scanner.nextLine());
                run();
                break;
            }
            case "3": {
                printInputParameter("ID");
                dw.findDeveloperById(scanner.nextLine());
                run();
                break;
            }
            case "4": {
                printInputParameter("ID");
                dw.deleteDeveloper(scanner.nextLine());
                run();
                break;
            }
            case "5": {
                run();
                break;
            }
        }
    }

    private void goToSkillSubGeneralMenu() {
        switch (scanner.nextLine()) {
            default: {
                printWrongSelection();
                run();
                break;
            }
            case "1": {
                sw.showSkills();
                run();
                break;
            }
            case "2": {
                printInputParameter("Skill Name");
                sw.createSkill(scanner.nextLine());
                run();
                break;
            }
            case "3": {
                printInputParameter("ID");
                sw.findSkillById(scanner.nextLine());
                run();
                break;
            }
            case "4": {
                printInputParameter("ID");
                sw.deleteSkill(scanner.nextLine());
                run();
                break;
            }
            case "5": {
                break;
            }
        }
    }



/*



    public static void printInputParametersToCreateDeveloper(){
        System.out.println("\nEnter First Name, Last Name, Address, Title, Data:");
    }

    public static void printCreatedSkill(Skill skill) {
        System.out.println("Skill '" + skill.getName() + "' successfully created with ID = " + skill.getId());
    }



    public static void printAccountStatus(){
        System.out.println("1 - ACTIVE, 2 - BANNED, 3 - DELETED");
    }

    public static void printCreatedDeveloper(Developer dev) {
        System.out.println("Developer '" + dev.getFullName() + "' successfully created with ID = " + dev.getId());
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
                    if (dev.getId().equals(acc.getId())) {
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
*/
}
