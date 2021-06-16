package com.tcm.community.model;

import java.io.Serializable;

public class PostBravo implements Serializable {

    private Long pbid;
    private Long pid;
    private Integer uid;
    private Integer isdel;
    private Long optime;

    public Long getPbid() {
        return pbid;
    }

    public void setPbid(Long pbid) {
        this.pbid = pbid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Long getOptime() {
        return optime;
    }

    public void setOptime(Long optime) {
        this.optime = optime;
    }

    @Override
    public String toString() {
        return "PostBravo{" +
                "pbid=" + pbid +
                ", pid=" + pid +
                ", uid=" + uid +
                ", isdel=" + isdel +
                ", optime=" + optime +
                '}';
    }
}
