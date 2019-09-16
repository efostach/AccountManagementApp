package com.efostach.ams.model;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer id;
    private String title;
    private String data;
    private AccountStatus status;

    public Account() {
        this.id = null;
        this.title = null;
        this.data = null;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setTitle(String value){
        this.title = value;
    }

    public void setData(String value){
        this.data = value;
    }

    public void setStatus(AccountStatus status){
        this.status = status;
    }

    public void setAccountStatus(AccountStatus status){
        this.status = status;
    }

    public Integer getId(){
        return this.id;
    }

    public String getStatus(){
        return String.valueOf(this.status);
    }

    public String getTitle(){
        return this.title;
    }

    public String getData(){
        return this.data;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(title).append(",")
                .append(data).append(",")
                .append(status)
                .append("\n").toString();
    }
}
