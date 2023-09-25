package com.mirea.kt.android2023;

public class Museums {
    private int id;
    private String address;
    private int telephone;
    private String website;

    public Museums(int id, String address, int telephone, String website) {
        this.id = id;
        this.address = address;
        this.telephone = telephone;
        this.website = website;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getAddress() {return address;}

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
