package com.tcm.community.model;

import java.io.Serializable;

public class PostCommentcount implements Serializable {

    private Long pccid;
    private Long pid;
    private Integer count;

    public Long getPccid() {
        return pccid;
    }

    public void setPccid(Long pccid) {
        this.pccid = pccid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PostCommentcount{" +
                "pccid=" + pccid +
                ", pid=" + pid +
                ", count=" + count +
                '}';
    }
}
