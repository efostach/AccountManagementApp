package main.java.com.efostach.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Account implements Serializable {
    private Integer ID;
    private String title;
    private String data;
    private accountStatus status;
    enum accountStatus {ACTIVE, BANNED, DELETED}
    public static Set<Account> accounts = new HashSet<>();

    public Account(Integer id, String title, String data) {
        this.ID = id;
        this.title = title;
        this.data = data;
        this.status = accountStatus.ACTIVE;
    }

    public Integer getID(){
        return this.ID;
    }

    public String getStatus(){
        return this.status.toString();
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String value){
        this.title = value;
    }

    public void setData(String value){
        this.data = value;
    }

    public void setBannedAccount(){
        this.status = accountStatus.BANNED;
    }

    public void setDeletedAccount(){
        this.status = accountStatus.DELETED;
    }

    public void setActiveAccount(){
        this.status = accountStatus.ACTIVE;
    }


    @Override
    public String toString(){
        return new StringBuilder().append("\n").append("ID: ").append(ID).append("\t")
                .append("Title: ").append(title).append("\t")
                .append("Data: ").append(data).append("\t")
                .append("Status: ").append(status).toString();
    }
}
