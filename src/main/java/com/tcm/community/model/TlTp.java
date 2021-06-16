package com.tcm.community.model;

import java.io.Serializable;

public class TlTp implements Serializable {

    private Long tlpid;
    private Long tlid;
    private Long pid;
    private Integer uid;

    public Long getTlpid() {
        return tlpid;
    }

    public void setTlpid(Long tlpid) {
        this.tlpid = tlpid;
    }

    public Long getTlid() {
        return tlid;
    }

    public void setTlid(Long tlid) {
        this.tlid = tlid;
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
        return "TlTp{" +
                "tlpid=" + tlpid +
                ", tlid=" + tlid +
                ", pid=" + pid +
                ", uid=" + uid +
                '}';
    }
}
