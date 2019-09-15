package com.efostach.ams.service;

import com.efostach.ams.model.Developer;
import com.efostach.ams.model.Skill;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class DeveloperService {

    public Set<Integer> addSkillToDeveloper(Developer developer, Set<Integer> ids) throws FileNotFoundException {
        SkillService skillService = new SkillService();
        Set<Integer> missingSkills = new HashSet<>();
        Integer skillId;
        Skill skill;

        for (Integer id : ids) {
            skill = skillService.checkIfSkillExist(id);
            if (skill != null) {
                skillId = skill.getId();
                developer.setSkill(skillId);
                missingSkills.add(skillId);
            }
        }
        return missingSkills;
    }

    protected Set<Developer> findDevelopersBySkill(Integer skillId) { return null; }
}
