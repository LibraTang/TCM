package com.tcm.community.model;

import java.io.Serializable;

public class NotifyNu implements Serializable {

    private Long nuid;
    private Long nid;
    private Integer uid;

    public Long getNuid() {
        return nuid;
    }

    public void setNuid(Long nuid) {
        this.nuid = nuid;
    }

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "NotifyNu{" +
                "nuid=" + nuid +
                ", nid=" + nid +
                ", uid=" + uid +
                '}';
    }
}
