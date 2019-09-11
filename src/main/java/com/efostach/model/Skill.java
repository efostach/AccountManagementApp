package main.java.com.efostach.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Skill implements Serializable {
    private Integer ID;
    private String name;
    private static Integer maxID = 0;
    public static Set<Skill> skills = new HashSet<>();

    public Skill(String name){
        this.ID = ++maxID;
        this.name = name;
    }

    public Integer getID(){
        return this.ID;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return new StringBuilder().append("\n").append("ID: ").append(ID).append("   ")
                .append("Name: ").append(name).append("   ").toString();
    }
}
