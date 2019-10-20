package com.bilgeadam.mobileonlinefoodapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meal {

    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private String price;
    @JsonProperty("photo")
    private String photo;
    @JsonProperty("detail")
    private String detail;


    public Meal(String code) {
        this.code = code;
    }

    public Meal(String code, String name, String price, String photo, String detail) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.photo = photo;
        this.detail = detail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
