package com.tcm.community.model;

import java.io.Serializable;

public class PostDetail implements Serializable {

    private Long pid;
    private Integer uid;
    private Integer isdel;
    private Long ctime;
    private Long mtime;
    private String word;
    private String img;
    private String video;
    private String audio;
    private String tag;
    private String title;
    private Integer top;

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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "PostDetail{" +
                "pid=" + pid +
                ", uid=" + uid +
                ", isdel=" + isdel +
                ", ctime=" + ctime +
                ", mtime=" + mtime +
                ", word='" + word + '\'' +
                ", img='" + img + '\'' +
                ", video='" + video + '\'' +
                ", audio='" + audio + '\'' +
                ", tag='" + tag + '\'' +
                ", title='" + title + '\'' +
                ", top=" + top +
                '}';
    }
}
