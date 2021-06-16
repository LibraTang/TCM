package com.tcm.community.model;

import java.io.Serializable;

public class UserAcc implements Serializable {

    private Integer uid;
    private String uname;
    private String pword;
    private String name;
    /**
     * 0:普通用户 1:机构用户(医生)
     */
    private Integer auth;
    private Integer isdel;
    private String salt;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "UserAcc{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pword='" + pword + '\'' +
                ", name='" + name + '\'' +
                ", auth=" + auth +
                ", isdel=" + isdel +
                ", salt='" + salt + '\'' +
                '}';
    }
}