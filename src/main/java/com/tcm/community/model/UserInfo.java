package com.tcm.community.model;

import java.io.Serializable;

public class UserInfo implements Serializable {

    private Integer uiid;
    private Integer age;
    private Integer sex;
    private String email;
    private Long ctime;
    private String province;
    private String city;
    private String region;
    private String location;
    private String selfintro;
    private String pic;
    private String tag;
    private Integer isidenti;
    private Integer type;

    public Integer getUiid() {
        return uiid;
    }

    public void setUiid(Integer uiid) {
        this.uiid = uiid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSelfintro() {
        return selfintro;
    }

    public void setSelfintro(String selfintro) {
        this.selfintro = selfintro;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getIsidenti() {
        return isidenti;
    }

    public void setIsidenti(Integer isidenti) {
        this.isidenti = isidenti;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uiid=" + uiid +
                ", age=" + age +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", ctime=" + ctime +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", location='" + location + '\'' +
                ", selfintro='" + selfintro + '\'' +
                ", pic='" + pic + '\'' +
                ", tag='" + tag + '\'' +
                ", isidenti=" + isidenti +
                ", type=" + type +
                '}';
    }
}
