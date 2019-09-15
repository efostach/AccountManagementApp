package com.efostach.ams.repository;

import com.efostach.ams.model.Skill;

import java.io.IOException;

public interface SkillRepository extends GenericRepository<Skill, Integer> {

    void delete(Integer id) throws IOException;

}
