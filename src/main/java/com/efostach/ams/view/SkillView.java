package com.efostach.ams.view;

import com.efostach.ams.controller.SkillController;
import com.efostach.ams.controller.exceptions.EmptyFileException;
import com.efostach.ams.controller.exceptions.InvalidValueException;
import com.efostach.ams.controller.exceptions.ObjectNotFoundException;
import com.efostach.ams.controller.exceptions.OperationFailException;
import com.efostach.ams.model.Skill;

import java.util.Iterator;


public class SkillView {

    private SkillController controller = new SkillController();

    void showSkills(){
        try {
            Iterator iterator = controller.showSkills().iterator();
            while (iterator.hasNext()){
                printDeveloper((Skill) iterator.next());
            }
        } catch (EmptyFileException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void findSkillById(String id){
        try {
            printDeveloper(controller.findSkillById(Integer.valueOf(id)));
        } catch (InvalidValueException | OperationFailException | ObjectNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void createSkill(String name){
        try {
            printDeveloper(controller.createSkill(name));
        } catch (OperationFailException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void deleteSkill(String id){
        try {
            controller.deleteSkill(Integer.valueOf(id));
        } catch (InvalidValueException | OperationFailException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void printDeveloper(Skill skill){
        System.out.println("Id: " + skill.getId() + "\tName: " + skill.getName());
    }
}
