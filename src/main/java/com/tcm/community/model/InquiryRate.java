package com.tcm.community.model;


import java.util.Date;

public class InquiryRate {
  /**
   * 主键
   */
  private Integer irid;
  /**
   * 问诊id
   */
  private Integer idid;
  /**
   * 问诊评分
   */
  private Double rate;
  private Date ctime;
  private Date utime;
  private Integer mark;

  public Integer getIrid() {
    return irid;
  }

  public void setIrid(Integer irid) {
    this.irid = irid;
  }

  public Integer getIdid() {
    return idid;
  }

  public void setIdid(Integer idid) {
    this.idid = idid;
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
    return "InquiryRate{" +
            "irid=" + irid +
            ", idid=" + idid +
            ", rate=" + rate +
            ", ctime=" + ctime +
            ", utime=" + utime +
            ", mark=" + mark +
            '}';
  }
}
