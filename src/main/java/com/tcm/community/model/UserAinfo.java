package com.tcm.community.model;

import java.io.Serializable;

public class UserAinfo implements Serializable {

    private Integer uaid;
    private Integer uid;
    private Integer uiid;

    public Integer getUaid() {
        return uaid;
    }

    public void setUaid(Integer uaid) {
        this.uaid = uaid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUiid() {
        return uiid;
    }

    public void setUiid(Integer uiid) {
        this.uiid = uiid;
    }

    @Override
    public String toString() {
        return "UserAinfo{" +
                "uaid=" + uaid +
                ", uid=" + uid +
                ", uiid=" + uiid +
                '}';
    }
}
