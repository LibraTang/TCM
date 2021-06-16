package com.tcm.community.model;

import java.io.Serializable;

public class Tl implements Serializable {

    private Long tlid;
    private String title;
    private String intro;
    private Integer isdel;
    private Long ctime;
    private Long mtime;

    public Long getTlid() {
        return tlid;
    }

    public void setTlid(Long tlid) {
        this.tlid = tlid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getMtime() {
        return mtime;
    }

    public void setMtime(Long mtime) {
        this.mtime = mtime;
    }

    @Override
    public String toString() {
        return "Tl{" +
                "tlid=" + tlid +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", isdel=" + isdel +
                ", ctime=" + ctime +
                ", mtime=" + mtime +
                '}';
    }
}
