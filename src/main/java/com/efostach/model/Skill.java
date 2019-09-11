package main.java.com.efostach.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Skill implements Serializable {
    public static Set<Skill> skills = new HashSet<>();
    private static Integer counerId = 0;
    private Integer id;
    private String name;


    public Skill(String name){
        this.id = ++counerId;
        this.name = name;
    }

    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return new StringBuilder().append("\n").append("Id: ").append(id).append("   ")
                .append("Name: ").append(name).append("   ").toString();
    }
}
