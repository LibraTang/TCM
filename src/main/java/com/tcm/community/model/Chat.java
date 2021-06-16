package com.tcm.community.model;

import java.io.Serializable;

public class Chat implements Serializable {

    private Long cid;
    private Integer fuid;
    private Integer tuid;
    private String chatid;
    private String content;
    private Integer status;
    private Long ctime;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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

    public String getChatid() {
        return chatid;
    }

    public void setChatid(String chatid) {
        this.chatid = chatid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "cid=" + cid +
                ", fuid=" + fuid +
                ", tuid=" + tuid +
                ", chatid=" + chatid +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", ctime=" + ctime +
                '}';
    }
}
