package main.java.com.efostach.repository;

import main.java.com.efostach.model.Developer;

import java.io.*;
import java.util.Set;

public class JavaIODeveloperRepository implements DeveloperRepository {

    private File file = new File("developer.txt");

    public void writeDataToFile(Set<Developer> developers) {
        try (FileOutputStream out = new FileOutputStream(file)){
            ObjectOutputStream ous = new ObjectOutputStream(out);
            ous.writeObject(developers.toString());
        } catch (IOException e){
            System.out.println("The file can't be closed. \n" + e);
        }

    }
}
