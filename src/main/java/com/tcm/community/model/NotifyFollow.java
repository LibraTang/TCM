package com.tcm.community.model;

import java.io.Serializable;

public class NotifyFollow implements Serializable {

    private Long nfid;
    private Long nid;
    private Integer fuid;
    private Integer tuid;
    private Integer isdel;
    private Long time;

    public Long getNfid() {
        return nfid;
    }

    public void setNfid(Long nfid) {
        this.nfid = nfid;
    }

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public Integer getFuid() {
        return fuid;
    }

    public void setFuid(Integer fuid) {
        this.fuid = fuid;
    }

    public Integer getTuid() {
        return tuid;
    }

    public void setTuid(Integer tuid) {
        this.tuid = tuid;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "NotifyFollow{" +
                "nfid=" + nfid +
                ", nid=" + nid +
                ", fuid=" + fuid +
                ", tuid=" + tuid +
                ", isdel=" + isdel +
                ", time='" + time + '\'' +
                '}';
    }
}
