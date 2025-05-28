package com.lnmt.lenguyenminhthao_k224111462_k22411c.models;

public class Account {
    private int id;
    private String usr;
    private String pwd;

    public Account() {
    }

    public Account(int id, String usr, String pwd) {
        this.id = id;
        this.usr = usr;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
