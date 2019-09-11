package main.java.com.efostach.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Developer implements Serializable {
    private Integer ID;
    private static Integer maxID = 0;
    private String firstName;
    private String lastName;
    private String address;
    private Set<Integer> skillSet = new HashSet<>();
    public static Set<Developer> developers = new HashSet<>();

    public Developer(String firstName, String lastName, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.ID = ++maxID;
    }

    public Integer getID(){
        return this.ID;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public Set<Integer> getSkillSet(){
        return this.skillSet;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setFirstName(String name){
        this.firstName = name;
    }

    public void setLastName(String name){
        this.firstName = name;
    }

    public void setSkillSet(Integer id){
        this.skillSet.add(id);
    }

    @Override
    public String toString(){
        return new StringBuilder().append("\n").append("ID: ").append(ID).append("\t")
                .append("Full Name: ").append(firstName).append(" ").append(lastName).append("\t")
                .append("Address: ").append(address).append("\t")
                .append("SkillSetIDs: ").append(skillSet).toString();
    }

}
