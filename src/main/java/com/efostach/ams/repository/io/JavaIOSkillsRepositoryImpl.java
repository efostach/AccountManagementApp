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

    public Skill getById(Integer id) throws FileNotFoundException {
        Iterator iterator = stringToSkill().iterator();
        Skill result = null;
        while (iterator.hasNext()) {
            Skill skill = (Skill) iterator.next();
            if (id.equals(skill.getId())) {
                result = skill;
            }
        }
        return result;
    }

    public List<Skill> getAll() throws FileNotFoundException {
        return stringToSkill();
    }

    public Skill create(Skill skill) throws IOException {
        skill.setId(getIncrementedId(file));
        writeDataToFile(file, skill.toString());
        return skill;
    }

    public Skill update(Skill skill) {
        return null;
    }

    public void delete(Integer id) throws IOException {
        Iterator iterator = stringToSkill().iterator();

        clearFile(file);
        while (iterator.hasNext()) {
            Skill skill = (Skill) iterator.next();
            if (!id.equals(skill.getId())) {
                writeDataToFile(file, skill.toString());
            }

        }
    }

    private List<Skill> stringToSkill() throws FileNotFoundException {
        List<Skill> skillSet = new ArrayList<>();
        Iterator iterator = readDataFromFile(file).iterator();

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
