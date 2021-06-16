package com.tcm.community.model;

import java.io.Serializable;

public class UserToken implements Serializable {

    private Long utid;
    private Integer uid;
    private String token;
    private Long expired;
    private Integer status;
    private Long logintime;

    public Long getUtid() {
        return utid;
    }

    public void setUtid(Long utid) {
        this.utid = utid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getExpired() {
        return expired;
    }

    public void setExpired(Long expired) {
        this.expired = expired;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getLogintime() {
        return logintime;
    }

    public void setLogintime(Long logintime) {
        this.logintime = logintime;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "utid=" + utid +
                ", uid=" + uid +
                ", token='" + token + '\'' +
                ", expired=" + expired +
                ", status=" + status +
                ", logintime=" + logintime +
                '}';
    }
}
