package main.java.com.efostach.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Account implements Serializable {
    private Integer id;
    private String title;
    private String data;
    private accountStatus status;
    enum accountStatus {ACTIVE, BANNED, DELETED}
    public static Set<Account> accounts = new HashSet<>();

    public Account(Integer id, String title, String data) {
        this.id = id;
        this.title = title;
        this.data = data;
        this.status = accountStatus.ACTIVE;
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
        return new StringBuilder().append("\n").append("Id: ").append(id).append("\t")
                .append("Title: ").append(title).append("\t")
                .append("Data: ").append(data).append("\t")
                .append("Status: ").append(status).toString();
    }
}
