package com.tcm.community.model;

import java.io.Serializable;

public class PostComment implements Serializable {

    private Long pcmid;
    private String detail;
    private Integer isdel;
    private Long ctime;
    private Long mtime;
    private Integer bravo;
    private String img;
    private Integer commenttype;

    public Long getPcmid() {
        return pcmid;
    }

    public void setPcmid(Long pcmid) {
        this.pcmid = pcmid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public Integer getBravo() {
        return bravo;
    }

    public void setBravo(Integer bravo) {
        this.bravo = bravo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getCommenttype() {
        return commenttype;
    }

    public void setCommenttype(Integer commenttype) {
        this.commenttype = commenttype;
    }

    @Override
    public String toString() {
        return "PostComment{" +
                "pcmid=" + pcmid +
                ", detail='" + detail + '\'' +
                ", isdel=" + isdel +
                ", ctime=" + ctime +
                ", mtime=" + mtime +
                ", bravo=" + bravo +
                ", img='" + img + '\'' +
                ", commenttype=" + commenttype +
                '}';
    }
}
