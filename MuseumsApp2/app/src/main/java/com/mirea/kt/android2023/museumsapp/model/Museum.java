package com.mirea.kt.android2023.museumsapp.model;

public class Museum {

    private int id;
    private String name;
    private String description;
    private String phoneNumber;
    private String url;
    private String address;
    private int imagePath;

    public Museum(int id, String name, String description, String phoneNumber, String url, String address, int imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.url = url;
        this.address = address;
        this.imagePath = imagePath;
    }

    public Museum(String name, String description, String phoneNumber, String url, String address, int imagePath) {
        this.name = name;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.url = url;
        this.address = address;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }
}
