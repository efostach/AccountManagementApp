package com.efostach.ams.repository.io;

import com.efostach.ams.model.Developer;
import com.efostach.ams.repository.DeveloperRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.efostach.ams.repository.io.IOUtil.*;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {

    private static String file = "src/main/resources/files/developer.txt";

    public Developer getById(Integer id) {
        Iterator iterator = stringToDeveloper().iterator();
        Developer result = null;
        while (iterator.hasNext()) {
            Developer dev = (Developer) iterator.next();
            if (id == dev.getId()) {
                result = dev;
            }
        }
        return result;
    }

    public List<Developer> getAll() {
        return stringToDeveloper();
    }

    public Developer create(Developer developer) {
        try {
            developer.setId(getIncrementedId(file));
            writeDataToFile(file, developer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return developer;
    }

    public Developer update(Developer developer) {
        return null;
    }

    public void delete(Integer id) {
        Iterator iterator = stringToDeveloper().iterator();

        try {
            clearFile(file);
            while (iterator.hasNext()) {
                Developer dev = (Developer) iterator.next();
                if (id != dev.getId()) {
                    writeDataToFile(file, dev.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Developer> stringToDeveloper() {
        List<Developer> developerSet = new ArrayList<>();
        Iterator iterator = null;

        try {
            iterator = readDataFromFile(file).iterator();
        } catch (FileNotFoundException e) {
            new FileNotFoundException("File not found : " + e);
        }

        while (iterator.hasNext()) {
            String element = (String) iterator.next();
            String[] attributes = element.split(REGEX);

            Developer dev = new Developer();
            dev.setId(Integer.valueOf(attributes[0]));
            dev.setFirstName(attributes[1]);
            dev.setLastName(attributes[2]);
            dev.setAddress(attributes[3]);
            if(!attributes[4].equals("null")) {
                dev.setAccountId(Integer.valueOf(attributes[4]));
            }
            for(int i = 5; i < attributes.length; i++) {
                dev.setSkill(Integer.valueOf(attributes[i]));
            }
            developerSet.add(dev);
        }
        return developerSet;
    }
}
