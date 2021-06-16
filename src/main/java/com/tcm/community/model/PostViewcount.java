package com.tcm.community.model;

import java.io.Serializable;

public class PostViewcount implements Serializable {

        private Long pvid;
        private Long pid;
        private Integer viewcount;

    public Long getPvid() {
        return pvid;
    }

    public void setPvid(Long pvid) {
        this.pvid = pvid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getViewcount() {
        return viewcount;
    }

    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    @Override
    public String toString() {
        return "PostViewcount{" +
                "pvid=" + pvid +
                ", pid=" + pid +
                ", viewcount=" + viewcount +
                '}';
    }
}
