package com.efostach.ams.model;

import java.io.Serializable;

public class Skill implements Serializable {
    private Integer id;
    private String name;

    public Skill(){
        this.id = null;
        this.name = null;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(name).append("\n")
                .toString();
    }
}
