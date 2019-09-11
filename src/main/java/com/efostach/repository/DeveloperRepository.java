package main.java.com.efostach.repository;

import main.java.com.efostach.model.Developer;

import java.util.Set;

public interface DeveloperRepository extends GenericRepository<Developer, Integer>{
    void writeDataToFile(Set<Developer> developers);
}
