package com.tcm.community.model;

import java.io.Serializable;

public class PostDc implements Serializable {

    private Long pdcid;
    private Long pcmid;
    private Long pid;
    private Integer uid;

    public Long getPdcid() {
        return pdcid;
    }

    public void setPdcid(Long pdcid) {
        this.pdcid = pdcid;
    }

    public Long getPcmid() {
        return pcmid;
    }

    public void setPcmid(Long pcmid) {
        this.pcmid = pcmid;
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

    @Override
    public String toString() {
        return "PostDc{" +
                "pdcid=" + pdcid +
                ", pcmid=" + pcmid +
                ", pid=" + pid +
                ", uid=" + uid +
                '}';
    }
}
