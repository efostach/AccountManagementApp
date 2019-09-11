package main.java.com.efostach.repository;

import main.java.com.efostach.model.Skill;

import java.util.Set;

public interface SkillRepository extends GenericRepository<Skill, Integer>{
    void writeDataToFile(Set<Skill> skills);
}
