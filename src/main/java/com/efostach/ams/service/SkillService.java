package com.efostach.ams.service;

import com.efostach.ams.model.Skill;
import com.efostach.ams.repository.io.JavaIOSkillsRepositoryImpl;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SkillService {

    private JavaIOSkillsRepositoryImpl ioSkill = new JavaIOSkillsRepositoryImpl();

    public boolean deleteSkill(Integer id) throws IOException {
//        if (!checkIfSkillAssigned(id)) {
//            ioSkill.delete(id);
//            return true;
//        } else
            return false;
    }

    protected Skill checkIfSkillExist(Integer id) throws FileNotFoundException {
        return ioSkill.getById(id);
    }
    protected boolean checkIfSkillAssigned(Integer id) throws FileNotFoundException {
        DeveloperService devService = new DeveloperService();

        if(checkIfSkillExist(id) != null){
            if(!devService.findDevelopersBySkill(id).isEmpty()){
                return true;
            }
        }
        return false;
    }
}
