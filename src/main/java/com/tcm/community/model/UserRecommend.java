package com.tcm.community.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 医生推荐指标
 */
public class UserRecommend implements Serializable {
    /**
     * 主键
     */
    private Integer urid;
    /**
     * 医生id
     */
    private Integer uid;
    /**
     * 医生所属科室
     */
    private Integer type;
    /**
     * 医生历史累计回答数
     */
    private Integer answerNumber;
    /**
     * 医生评分(5分制)
     */
    private Double rate;
    private Date ctime;
    private Date utime;
    private Integer mark;

    public Integer getUrid() {
        return urid;
    }

    public void setUrid(Integer urid) {
        this.urid = urid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(Integer answerNumber) {
        this.answerNumber = answerNumber;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
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
        return "UserRecommend{" +
                "urid=" + urid +
                ", uid=" + uid +
                ", type=" + type +
                ", answerNumber=" + answerNumber +
                ", rate=" + rate +
                ", ctime=" + ctime +
                ", utime=" + utime +
                ", mark=" + mark +
                '}';
    }
}
