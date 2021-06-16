package com.tcm.community.model;

import java.io.Serializable;

public class PostBravocount implements Serializable {

    private Long pbvid;
    private Long pid;
    private Integer bravocount;

    public Long getPbvid() {
        return pbvid;
    }

    public void setPbvid(Long pbvid) {
        this.pbvid = pbvid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getBravocount() {
        return bravocount;
    }

    public void setBravocount(Integer bravocount) {
        this.bravocount = bravocount;
    }

    @Override
    public String toString() {
        return "PostBravocount{" +
                "pbvid=" + pbvid +
                ", pid=" + pid +
                ", bravocount=" + bravocount +
                '}';
    }
}
