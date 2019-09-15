package com.efostach.ams.repository;

import com.efostach.ams.model.Developer;

import java.io.FileNotFoundException;

public interface DeveloperRepository extends GenericRepository<Developer, Integer>{

    void delete(Integer id) throws FileNotFoundException;
}
