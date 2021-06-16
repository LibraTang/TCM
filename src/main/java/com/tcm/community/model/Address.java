package com.tcm.community.model;

import java.io.Serializable;

public class Address implements Serializable {

    private int status;
    private String message;
    private Result result;
    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setResult(Result result) {
        this.result = result;
    }
    public Result getResult() {
        return result;
    }

}

class Ad_info {

    private String adcode;
    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }
    public String getAdcode() {
        return adcode;
    }

}

class Address_components {

    private String province;
    private String city;
    private String district;
    private String street;
    private String street_number;
    public void setProvince(String province) {
        this.province = province;
    }
    public String getProvince() {
        return province;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    public String getDistrict() {
        return district;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public String getStreet() {
        return street;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }
    public String getStreet_number() {
        return street_number;
    }

}

class Result {

    private String title;
    private Location location;
    private Ad_info ad_info;
    private Address_components address_components;
    private double similarity;
    private int deviation;
    private int reliability;
    private int level;
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    public Location getLocation() {
        return location;
    }

    public void setAd_info(Ad_info ad_info) {
        this.ad_info = ad_info;
    }
    public Ad_info getAd_info() {
        return ad_info;
    }

    public void setAddress_components(Address_components address_components) {
        this.address_components = address_components;
    }
    public Address_components getAddress_components() {
        return address_components;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }
    public double getSimilarity() {
        return similarity;
    }

    public void setDeviation(int deviation) {
        this.deviation = deviation;
    }
    public int getDeviation() {
        return deviation;
    }

    public void setReliability(int reliability) {
        this.reliability = reliability;
    }
    public int getReliability() {
        return reliability;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }

}