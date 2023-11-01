package com.mirea.kt.android2023;

public class Museums {
    private int id;
    private String name;
    private String address;
    private String telephone;
    private String website;
    private String picture;

    public Museums(int id, String name, String address, String telephone, String website) {
        this.id=id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.website = website;
    }
    public Museums( String name, String address, String telephone, String website) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.website = website;
    }
    public Museums(int id, String name, String picture) {
        this.id = id;
        this.name = name;
        this.picture = picture;
    }
    /*public Museums(String name, String address, String telephone, String website, String picture) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.website = website;
        this.picture = picture;
    }*/

    public Museums() {
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getAddress() {return address;}

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPicture() {return picture;}

    public void setPicture(String picture) {this.picture = picture;}
}
