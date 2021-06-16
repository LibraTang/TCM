package com.tcm.community.model;

import java.io.Serializable;

public class UserFollow implements Serializable {

    private Integer ufid;
    private Integer uid;
    private Integer fid;
    private Long optime;
    private Integer isdel;

    public Integer getUfid() {
        return ufid;
    }

    public void setUfid(Integer ufid) {
        this.ufid = ufid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Long getOptime() {
        return optime;
    }

    public void setOptime(Long optime) {
        this.optime = optime;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    @Override
    public String toString() {
        return "UserFollow{" +
                "ufid=" + ufid +
                ", uid=" + uid +
                ", fid=" + fid +
                ", optime=" + optime +
                ", isdel=" + isdel +
                '}';
    }
}
