package com.tcm.community.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 问诊处方
 */
public class InquiryPrescription implements Serializable {
    /**
     * 主键
     */
    private Integer ipid;
    /**
     * 问诊id
     */
    private Integer idid;
    /**
     * 处方内容
     */
    private String content;
    private Date ctime;
    private Date utime;
    private Integer mark;

    public Integer getIpid() {
        return ipid;
    }

    public void setIpid(Integer ipid) {
        this.ipid = ipid;
    }

    public Integer getIdid() {
        return idid;
    }

    public void setIdid(Integer idid) {
        this.idid = idid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "InquiryPrescription{" +
                "ipid=" + ipid +
                ", idid=" + idid +
                ", content='" + content + '\'' +
                ", ctime=" + ctime +
                ", utime=" + utime +
                ", mark=" + mark +
                '}';
    }
}
