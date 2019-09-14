package com.efostach.ams.repository;

import com.efostach.ams.model.Skill;

public interface SkillRepository extends GenericRepository<Skill, Integer> {

    void delete(Integer id);

}
