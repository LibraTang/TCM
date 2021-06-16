package com.tcm.community.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 问诊详情
 */
public class InquiryDetail implements Serializable {
    /**
     * 主键
     */
    private Integer idid;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 问诊内容
     */
    private String content;
    /**
     * 问诊科室
     */
    private Integer type;
    /**
     * 医生id
     */
    private Integer doctor;
    private Date ctime;
    private Date utime;
    private Integer mark;

    public Integer getIdid() {
        return idid;
    }

    public void setIdid(Integer idid) {
        this.idid = idid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDoctor() {
        return doctor;
    }

    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "InquiryDetail{" +
                "idid=" + idid +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", doctor=" + doctor +
                ", ctime=" + ctime +
                ", utime=" + utime +
                ", mark=" + mark +
                '}';
    }
}
