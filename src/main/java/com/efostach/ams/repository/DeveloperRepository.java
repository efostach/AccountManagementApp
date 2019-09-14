package com.efostach.ams.repository;

import com.efostach.ams.model.Developer;

public interface DeveloperRepository extends GenericRepository<Developer, Integer>{

    void delete(Integer id);
}
