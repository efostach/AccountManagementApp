package com.efostach.ams.repository.io;

import com.efostach.ams.model.Skill;
import com.efostach.ams.repository.SkillRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.efostach.ams.repository.io.IOUtil.*;

public class JavaIOSkillsRepositoryImpl implements SkillRepository {

    private static String file = "src/main/resources/files/skill.txt";

    public Skill getById(Integer id) {
        Iterator iterator = stringToSkill().iterator();
        Skill result = null;
        while (iterator.hasNext()) {
            Skill skill = (Skill) iterator.next();
            if (id == skill.getId()) {
                result = skill;
            }
        }
        return result;
    }

    public List<Skill> getAll() {
        return stringToSkill();
    }

    public Skill create(Skill skill) {
        try {
            skill.setId(getIncrementedId(file));
            writeDataToFile(file, skill.toString());

        } catch (IOException e) {
            new FileNotFoundException("File not found : " + e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return skill;
    }

    public Skill update(Skill skill) {
        return null;
    }

    public void delete(Integer id) {
        Iterator iterator = stringToSkill().iterator();

        try {
            clearFile(file);
            while (iterator.hasNext()) {
                Skill skill = (Skill) iterator.next();
                if (id != skill.getId()) {
                    writeDataToFile(file, skill.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Skill> stringToSkill() {
        List<Skill> skillSet = new ArrayList<>();
        Iterator iterator = null;

        try {
            iterator = readDataFromFile(file).iterator();
        } catch (FileNotFoundException e) {
            new FileNotFoundException("File not found : " + e);
        }

        while (iterator.hasNext()) {
            String element = (String) iterator.next();
            String[] attributes = element.split(REGEX);

            Skill skill = new Skill();
            skill.setId(Integer.valueOf(attributes[0]));
            skill.setName(attributes[1]);

            skillSet.add(skill);
        }
        return skillSet;
    }
}
