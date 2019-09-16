package com.efostach.ams.view;

import com.efostach.ams.controller.exceptions.InvalidValueException;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static com.efostach.ams.controller.ControllerUtil.getIntegerValue;

public class AppConsole {
    private AccountView aw = new AccountView();
    private DeveloperView dw = new DeveloperView();
    private SkillView sw = new SkillView();

    private Scanner scanner = new Scanner(System.in);

    private void printGeneralMenu() {
        System.out.println("\nFor choosing an action, please, enter the number.");
        System.out.println("1. Developers");
        System.out.println("2. Skills");
        System.out.println("3. Accounts");
        System.out.println("4. Exit \n");
    }

    private void printDeveloperSubGeneralMenu() {
        System.out.println("\nChoose necessary operation:");
        System.out.println("1. Show All Developers");
        System.out.println("2. Create Developer");
        System.out.println("3. Find Developer");
        System.out.println("4. Delete Developer");
        System.out.println("5. Go Back\n");
    }

    private void printSkillSubGeneralMenu() {
        System.out.println("\nChoose necessary operation:");
        System.out.println("1. Show All Skills");
        System.out.println("2. Create Skill");
        System.out.println("3. Find Skill");
        System.out.println("4. Delete Skill");
        System.out.println("5. Go Back\n");
    }

    private void printAccountSubGeneralMenu() {
        System.out.println("\nChoose necessary operation:");
        System.out.println("1. Show All Accounts");
        System.out.println("2. Go Back\n");
    }

    private void printWrongSelection() {
        System.out.println("Oops, it's wrong value.\n");
    }

    private void printInputParameter(String name) {
        System.out.println("\nEnter " + name + ":");
    }

    private void printMessage(String message) {
        System.out.println("\n" + message + "\n");
    }

    public void run() {
        printGeneralMenu();

        switch (scanner.nextLine()) {
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
                printAccountSubGeneralMenu();
                goToAccountSubGeneralMenu();
                break;
            }
            case "4": {
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
                printInputParameter("First Name, Last Name, Address, Title, Additional Information");
                String firstName = getFieldInputValue();
                String lastName = getFieldInputValue();
                String address = getFieldInputValue();
                String title = getFieldInputValue();
                String data = getFieldInputValue();
                Set<Integer> skillIds = new HashSet<>();
                if (sw.checkIfSkillsExist()) {
                    printMessage("Choose Skills to assign one or more to Developer. For complete creation, please, enter 0.");
                    sw.showSkills();
                    printInputParameter("ID");
                    skillIds = getSeveralIntegerValues();
                }
                dw.createDeveloper(firstName, lastName, address, title, data, skillIds);
                run();
                break;
            }
            case "3": {
                printInputParameter("ID");
                dw.findDeveloperById(transferToIntegerValue());
                run();
                break;
            }
            case "4": {
                printInputParameter("ID");
                dw.deleteDeveloper(transferToIntegerValue());
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
                sw.createSkill(getFieldInputValue());
                run();
                break;
            }
            case "3": {
                printInputParameter("ID");
                sw.findSkillById(transferToIntegerValue());
                run();
                break;
            }
            case "4": {
                printInputParameter("ID");
                sw.deleteSkill(transferToIntegerValue());
                run();
                break;
            }
            case "5": {
                break;
            }
        }
    }

    private void goToAccountSubGeneralMenu() {
        switch (scanner.nextLine()) {
            default: {
                printWrongSelection();
                run();
                break;
            }
            case "1": {
                aw.showAccounts();
                run();
                break;
            }
            case "2": {
                break;
            }
        }
    }

    private Set<Integer> getSeveralIntegerValues() {
        Set<Integer> result = new HashSet<>();
        Integer input = null;
        do {
            do {
                try {
                    input = getIntegerValue(scanner.nextLine());
                } catch (InvalidValueException ex) {
                    ex.getMessage();
                }
            } while (input == null);
            result.add(input);
        } while (!input.equals(0));
        return result;
    }

    private Integer transferToIntegerValue() {
        Integer input = null;
        do {
            try {
                input = getIntegerValue(scanner.nextLine());
            } catch (InvalidValueException ex) {
                ex.getMessage();
            }
        } while (input == null);
        return input;
    }

    private String getFieldInputValue() {
        String input;
        do {
            input = scanner.nextLine();
        } while (input.equals(""));
        return input;
    }
}
