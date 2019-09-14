package com.efostach.ams.view;

import com.efostach.ams.controller.SkillController;
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
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void findSkillById(String id){
        try {
            printDeveloper(controller.findSkillById(Integer.valueOf(id)));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void createSkill(String name){
        try {
            printDeveloper(controller.createSkill(name));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void deleteSkill(String id){
        try {
            controller.deleteSkill(Integer.valueOf(id));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void printDeveloper(Skill skill){
        System.out.println("Id: " + skill.getId() + "\tName: " + skill.getName());
    }
}
