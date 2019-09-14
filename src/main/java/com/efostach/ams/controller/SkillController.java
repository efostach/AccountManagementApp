package com.efostach.ams.controller;

import com.efostach.ams.model.Skill;
import com.efostach.ams.repository.io.JavaIOSkillsRepositoryImpl;

import java.util.List;

public class SkillController {

    private JavaIOSkillsRepositoryImpl ioSkills = new JavaIOSkillsRepositoryImpl();

    public List<Skill> showSkills() throws Exception {
        List<Skill> listSkills = ioSkills.getAll();
        if (ioSkills.getAll().isEmpty()) {
            throw new Exception("No skills exist.");
        } else
            return listSkills;
    }

    public Skill findSkillById(Integer id) throws Exception {
        if (id < 0) {
            throw new Exception("Invalid id value.");
        } else {
            Skill result = ioSkills.getById(id);
            if (result == null) {
                throw new Exception("Skill not found.");
            } else
                return result;
        }
    }

    public Skill createSkill(String name) throws Exception {
        Skill skill = new Skill();
        skill.setName(name);

        Skill createdSkill = ioSkills.create(skill);

        if (createdSkill == null) {
            throw new Exception("Skill can't be created.");
        } else
            return createdSkill;
    }

    public void deleteSkill(Integer id) throws Exception {
        if (id < 0) {
            throw new Exception("Invalid id value.");
        } else
            ioSkills.delete(id);
    }
}
