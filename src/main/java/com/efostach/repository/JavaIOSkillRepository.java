package main.java.com.efostach.repository;

import main.java.com.efostach.model.Skill;

import java.io.*;
import java.util.Set;

public class JavaIOSkillRepository implements SkillRepository {

    private File file = new File("skill.txt");

    public void writeDataToFile(Set<Skill> skills) {
        try (FileOutputStream out = new FileOutputStream(file)){
            ObjectOutputStream ous = new ObjectOutputStream(out);
            ous.writeObject(skills.toString());
        } catch (IOException e){
            System.out.println("The file can't be closed. \n" + e);
        }
    }
}
