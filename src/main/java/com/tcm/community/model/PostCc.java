package com.tcm.community.model;

import java.io.Serializable;

public class PostCc implements Serializable {

    private Long pcccid;
    private Long pcmid;
    private Long tpcmid;
    private Integer uid;

    public Long getPcccid() {
        return pcccid;
    }

    public void setPcccid(Long pcccid) {
        this.pcccid = pcccid;
    }

    public Long getPcmid() {
        return pcmid;
    }

    public void setPcmid(Long pcmid) {
        this.pcmid = pcmid;
    }

    public Long getTpcmid() {
        return tpcmid;
    }

    public void setTpcmid(Long tpcmid) {
        this.tpcmid = tpcmid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "PostCc{" +
                "pcccid=" + pcccid +
                ", pcmid=" + pcmid +
                ", tpcmid=" + tpcmid +
                ", uid=" + uid +
                '}';
    }
}
