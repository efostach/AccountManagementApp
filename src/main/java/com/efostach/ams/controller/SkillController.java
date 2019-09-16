package com.efostach.ams.controller;

import com.efostach.ams.controller.exceptions.EmptyFileException;
import com.efostach.ams.controller.exceptions.InvalidValueException;
import com.efostach.ams.controller.exceptions.ObjectNotFoundException;
import com.efostach.ams.controller.exceptions.OperationFailException;
import com.efostach.ams.model.Skill;
import com.efostach.ams.repository.io.JavaIOSkillsRepositoryImpl;
import com.efostach.ams.service.SkillService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static com.efostach.ams.controller.ControllerUtil.getIntegerValue;

public class SkillController {

    private JavaIOSkillsRepositoryImpl ioSkills = new JavaIOSkillsRepositoryImpl();
    private SkillService skillService = new SkillService();

    public List<Skill> showSkills() throws EmptyFileException {
        List<Skill> listSkills;
        try {
            listSkills = ioSkills.getAll();
            if (ioSkills.getAll().isEmpty())
                throw new EmptyFileException("No skills exist.");
        } catch (FileNotFoundException e) {
            throw new EmptyFileException("No skills exist.");
        }
        return listSkills;
    }

    public Skill findSkillById(Integer id) throws InvalidValueException, ObjectNotFoundException, OperationFailException {
        if (id < 0) {
            throw new InvalidValueException("Invalid id value.");
        } else {
            Skill result;
            try {
                result = ioSkills.getById(id);
                if (result == null) {
                    throw new ObjectNotFoundException("Skill not found.");
                }
            } catch (FileNotFoundException e) {
                throw new OperationFailException("Skill failed to be found.");
            }
            return result;
        }
    }

    public Skill createSkill(String name) throws OperationFailException {
        Skill skill = new Skill();
        skill.setName(name);

        Skill createdSkill;
        try {
            createdSkill = ioSkills.create(skill);
        } catch (IOException e) {
            throw new OperationFailException("Skill failed to be created.");
        }
        return createdSkill;

    }

    public void deleteSkill(Integer id) throws InvalidValueException, OperationFailException {
        if (id != null && id < 0) {
            throw new InvalidValueException("Invalid id value.");
        } else {
            try {
                if (!skillService.deleteSkill(id)) {
                    throw new OperationFailException("Skill assigned to Developers and can't be deleted.");
                }
            } catch (IOException e) {
                throw new OperationFailException("Skill failed to be deleted.");
            }
        }
    }

    public boolean checkIfSkillsExist() throws EmptyFileException {
        boolean result = false;
        try {
            if (ioSkills.getAll() != null) {
                result = true;
            }
        } catch (FileNotFoundException e) {
            throw new EmptyFileException("No skills exist.");
        }
        return result;
    }

}
