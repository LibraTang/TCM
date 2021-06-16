package com.tcm.community.model;

import java.io.Serializable;

public class NotifyPcomment implements Serializable {

    private Long npcmid;
    private Long nid;
    private Integer fuid;
    private Integer tuid;
    private Long pid;
    private String title;
    private Integer isdel;
    private Long time;

    public Long getNpcmid() {
        return npcmid;
    }

    public void setNpcmid(Long npcmid) {
        this.npcmid = npcmid;
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

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "NotifyPcomment{" +
                "npcmid=" + npcmid +
                ", nid=" + nid +
                ", fuid=" + fuid +
                ", tuid=" + tuid +
                ", pid=" + pid +
                ", title='" + title + '\'' +
                ", isdel=" + isdel +
                ", time='" + time + '\'' +
                '}';
    }
}
