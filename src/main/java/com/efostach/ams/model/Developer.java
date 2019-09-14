package com.efostach.ams.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Developer implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private Integer accountId;
    private Set<Integer> skillSet = new HashSet<>();

    public Developer(){
        this.id = null;
        this.firstName = null;
        this.lastName = null;
        this.address = null;
        this.accountId = null;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setFirstName(String name){
        this.firstName = name;
    }

    public void setLastName(String name){
        this.lastName = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setAccountId(Integer id){
        this.accountId = id;
    }

    public void setSkill(Integer skillId){
        this.skillSet.add(skillId);
    }

    public Integer getId(){
       return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public Integer getAccountId(){
        return this.accountId;
    }

    public Set<Integer> getSkillSet(){
        return this.skillSet;
    }



    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(firstName).append(",")
                .append(lastName).append(",")
                .append(address).append(",")
                .append(accountId).append(",")
                .append(skillSet)
                .append("\n").toString();
    }
}
