package main.java.com.efostach.controller;

import main.java.com.efostach.model.Account;
import main.java.com.efostach.model.Developer;
import main.java.com.efostach.model.Skill;
import main.java.com.efostach.repository.JavaIOAccountRepository;
import main.java.com.efostach.repository.JavaIODeveloperRepository;
import main.java.com.efostach.repository.JavaIOSkillRepository;

import java.util.Iterator;
import java.util.Scanner;

import static main.java.com.efostach.model.Account.accounts;
import static main.java.com.efostach.model.Developer.developers;
import static main.java.com.efostach.model.Skill.skills;
import static main.java.com.efostach.view.Menu.*;

class ApplicationLogic {

    private JavaIODeveloperRepository writeDev = new JavaIODeveloperRepository();
    private JavaIOAccountRepository writeAccount = new JavaIOAccountRepository();
    private JavaIOSkillRepository writeSkill = new JavaIOSkillRepository();

    private Scanner scanner = new Scanner(System.in);

    void start() {
        goToGeneralMenu();
    }

    private void goToGeneralMenu() {
        printGeneralMenu();
        switch (scanner.next()) {
            default: {
                printWrongSelection();
                goToGeneralMenu();
                break;
            }
            case "1": {
                goToDeveloperSubGeneralMenu();
                goToGeneralMenu();
                break;
            }
            case "2": {
                goToSkillSubGeneralMenu();
                break;
            }
            case "3":
                break;
        }
    }

    private void goToDeveloperSubGeneralMenu() {
        printDeveloperSubGeneralMenu();
        switch (scanner.next()) {
            default: {
                printWrongSelection();
                goToGeneralMenu();
                break;
            }
            case "1": {
                goToCreateDeveloper();
                goToGeneralMenu();
                break;
            }
            case "2": {
                goToFindDeveloper();
                goToGeneralMenu();
                break;
            }
            case "3": {
                goToEditDeveloperSubMenu();
                goToGeneralMenu();
                break;
            }
            case "4": {
                goToDeleteDeveloper();
                goToGeneralMenu();
                break;
            }
            case "5": {
                goToGeneralMenu();
                break;
            }
            case "6": {
                break;
            }
        }
    }

    private void goToSkillSubGeneralMenu() {
        printSkillSubGeneralMenu();
        switch (scanner.next()) {
            default: {
                printWrongSelection();
                goToGeneralMenu();
                break;
            }
            case "1": {
                goToCreateSkill();
                goToGeneralMenu();
                break;
            }
            case "2": {
                printElements(skills);
                goToGeneralMenu();
                break;
            }
            case "3": {
                goToGeneralMenu();
                break;
            }
            case "4": {
                break;
            }
        }
    }

    private void goToCreateSkill() {
        printInputParameter("Name");

        Skill skill = new Skill(scanner.next());
        skills.add(skill);
        writeSkill.writeDataToFile(skills);

        printCreatedSkill(skill);
    }

    private void goToCreateDeveloper() {
        printInputParametersToCreateDeveloper();

        Developer dev = new Developer(scanner.next(), scanner.next(), scanner.next());
        Account acc = new Account(dev.getId(), scanner.next(), scanner.next());

        developers.add(dev);
        accounts.add(acc);

        writeDev.writeDataToFile(developers);
        writeAccount.writeDataToFile(accounts);

        printCreatedDeveloper(dev);
    }

    private void goToFindDeveloper() {
        if (!developers.isEmpty()) {
            printInputParameter("Id");

            Iterator iterator = developers.iterator();
            Developer developer;
            boolean result = false;

            do {
                developer = (Developer) iterator.next();
                String id = String.valueOf(developer.getId());
                String input = scanner.next();
                if (id.equals(input)) {
                    result = true;
                }
            }
            while (iterator.hasNext() && !result);

            printSearchResult(result);
        } else
            printNoElementsExist("Developer");
    }

    private void goToDeleteDeveloper() {
        if (!developers.isEmpty()) {
            printElements(developers);
            printInputParameter("Id");
            String inputId = scanner.next();

            final Developer[] developer = new Developer[1];

            developers.forEach(element -> {
                String developerId = String.valueOf(element.getId());
                if (developerId.equals(inputId)) {
                    developer[0] = element;
                }
            });

            developers.remove(developer[0]);
            writeDev.writeDataToFile(developers);

            printRemovedObject();
        } else
            printNoElementsExist("Developer");
    }

    private void goToEditDeveloperSubMenu() {
        printEditDeveloperSubMenu();

        switch (scanner.next()) {
            default: {
                printWrongSelection();
                goToGeneralMenu();
                break;
            }
            case "1": {
                goToEditSkills();
                goToGeneralMenu();
                break;
            }
            case "2": {
                goToEditAddress();
                goToGeneralMenu();
                break;
            }
            case "3": {
                goToEditFirstName();
                goToGeneralMenu();
                break;
            }
            case "4": {
                goToEditLastName();
                goToGeneralMenu();
                break;
            }
            case "5": {
                goToEditTitle();
                goToGeneralMenu();
                break;
            }
            case "6": {
                goToEditData();
                goToGeneralMenu();
                break;
            }
            case "7": {
                goToEditAccountStatus();
                goToGeneralMenu();
                break;
            }
            case "8": {
                goToDeveloperSubGeneralMenu();
                break;
            }
            case "9": {
                break;
            }
        }
    }

    private void goToEditSkills() {
        printEditDeveloperSkillSubMenu();
        switch (scanner.next()) {
            default: {
                printWrongSelection();
                goToGeneralMenu();
                break;
            }
            case "1": {
                goToAddDeveloperSkill();
                break;
            }
            case "2": {
                goToDeleteDeveloperSkill();
                break;
            }
            case "3": {
                goToEditDeveloperSubMenu();
                break;
            }
            case "4": {
                break;
            }
        }
    }

    private void goToEditAddress() {
        if (!developers.isEmpty()) {
            printElements(developers);
            printInputParameter("Id");
            Developer dev = checkIfDeveloperExists(scanner.next());

            if (dev != null) {
                printInputParameter("Address");
                dev.setAddress(scanner.next());

                writeDev.writeDataToFile(developers);
            } else
                printSearchResult(false);
        } else
            printNoElementsExist("Developer");
    }

    private void goToEditFirstName() {
        if (!developers.isEmpty()) {
            printElements(developers);
            printInputParameter("Id");
            Developer dev = checkIfDeveloperExists(scanner.next());

            if (dev != null) {
                printInputParameter("First Name");
                dev.setFirstName(scanner.next());
                writeDev.writeDataToFile(developers);
            } else
                printSearchResult(false);
        } else
            printNoElementsExist("Developer");
    }

    private void goToEditLastName() {
        if (!developers.isEmpty()) {
            printElements(developers);
            printInputParameter("Id");
            Developer dev = checkIfDeveloperExists(scanner.next());

            if (dev != null) {
                printInputParameter("Last Name");
                dev.setLastName(scanner.next());
                writeDev.writeDataToFile(developers);
            } else
                printSearchResult(false);
        } else
            printNoElementsExist("Developer");
    }

    private void goToEditTitle() {
        if (!developers.isEmpty()) {
            printElements(developers);
            printInputParameter("Id");
            String inputId = scanner.next();

            if (checkIfDeveloperExists(inputId) != null) {
                accounts.forEach(element -> {
                    String id = String.valueOf(element.getId());

                    if (id.equals(inputId)) {
                        printInputParameter("Title");
                        element.setTitle(scanner.next());
                    }
                });
                writeAccount.writeDataToFile(accounts);
            } else
                printSearchResult(false);
        } else
            printNoElementsExist("Developer");
    }

    private void goToEditData() {
        if (!developers.isEmpty()) {
            printElements(developers);
            printInputParameter("Id");
            String inputId = scanner.next();

            if (checkIfDeveloperExists(inputId) != null) {
                accounts.forEach(element -> {
                    String id = String.valueOf(element.getId());

                    if (id.equals(inputId)) {
                        printInputParameter("Data");
                        element.setData(scanner.next());
                    }
                });
                writeAccount.writeDataToFile(accounts);
            } else
                printSearchResult(false);
        } else
            printNoElementsExist("Developer");
    }

    private void goToEditAccountStatus() {
        if (!developers.isEmpty()) {
            printElements();
            printInputParameter("Id");
            String inputId = scanner.next();

            if (checkIfDeveloperExists(inputId) != null) {
                accounts.forEach(element -> {
                    String id = String.valueOf(element.getId());

                    if (id.equals(inputId)) {
                        printAccountStatus();
                        printInputParameter("Account Status");
                        switch(scanner.next()) {
                            case "1": {
                                element.setActiveAccount();
                                break;
                            }
                            case "2": {
                                element.setBannedAccount();
                                break;
                            }
                            case "3": {
                                element.setDeletedAccount();
                                break;
                            }
                        }
                    }
                });
                writeAccount.writeDataToFile(accounts);
            } else
                printSearchResult(false);
        } else
            printNoElementsExist("Developer");
    }

    private void goToAddDeveloperSkill() {
        if (!developers.isEmpty()) {
            printElements();
            printInputParameter("Developer Id");

            Developer dev = checkIfDeveloperExists(scanner.next());

            if (dev != null) {
                if (!skills.isEmpty()) {
                    printElements(skills);
                    printInputParameter("Skill Id");

                    String inputId = scanner.next();

                    if (null != checkIfSkillExists(inputId)) {
                        dev.setSkillSet(Integer.valueOf(inputId));
                        writeDev.writeDataToFile(developers);
                        printElements(developers);
                    } else
                        printNotFoundElement("Skill");
                } else
                    printNoElementsExist("Skill");
            } else
                printNotFoundElement("Developer");
        } else
            printNoElementsExist("Developer");
    }

    private void goToDeleteDeveloperSkill() {
        if (!developers.isEmpty()) {
            printElements();
            printInputParameter("Developer Id");

            Developer dev = checkIfDeveloperExists(scanner.next());

            if (dev != null) {
                if (!skills.isEmpty()) {

                    printElements(dev.getSkillSet());
                    printInputParameter("Skill Id");

                    String inputId = scanner.next();

                    if (checkIfSkillExists(inputId) != null) {
                        dev.getSkillSet().remove(Integer.valueOf(inputId));
                        writeDev.writeDataToFile(developers);
                        printElements(developers);
                    } else
                        printNotFoundElement("Skill");
                } else
                    printNoElementsExist("Skill");
            } else
                printNotFoundElement("Developer");
        } else
            printNoElementsExist("Developer");
    }

    private Developer checkIfDeveloperExists(String input) {
        Iterator iterator = developers.iterator();
        Developer developer;

        do {
            developer = (Developer) iterator.next();
            String id = String.valueOf(developer.getId());
            if (id.equals(input)) {
                return developer;
            }
        }
        while (iterator.hasNext());

        return null;
    }

    private Skill checkIfSkillExists(String value) {
        Iterator iterator = skills.iterator();
        Skill skill;

        do {
            skill = (Skill) iterator.next();
            String id = String.valueOf(skill.getId());
            if (id.equals(value)) {
                return skill;
            }
        }
        while (iterator.hasNext());

        return null;
    }
}
