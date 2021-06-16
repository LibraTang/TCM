package com.tcm.community.model;

import java.io.Serializable;

public class Notify implements Serializable {

    private Long nid;
    private Integer type;
    private Integer isread;
    private Long time;

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsread() {
        return isread;
    }

    public void setIsread(Integer isread) {
        this.isread = isread;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Notify{" +
                "nid=" + nid +
                ", type=" + type +
                ", isread=" + isread +
                ", time='" + time + '\'' +
                '}';
    }
}
