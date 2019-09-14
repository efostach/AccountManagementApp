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
}
