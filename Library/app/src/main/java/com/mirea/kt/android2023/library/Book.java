package com.mirea.kt.android2023.library;

public class Book {

    private int id;
    private int shelfNumber;
    private int vendorCode;
    private String author;
    private int rackNumber;
    private String title;

    public Book(int id, int shelfNumber, int vendorCode, String author, int rackNumber, String title) {
        this.id = id;
        this.shelfNumber = shelfNumber;
        this.vendorCode = vendorCode;
        this.author = author;
        this.rackNumber = rackNumber;
        this.title = title;
    }

    public Book(int shelfNumber, int vendorCode, String author, int rackNumber, String title) {
        this.shelfNumber = shelfNumber;
        this.vendorCode = vendorCode;
        this.author = author;
        this.rackNumber = rackNumber;
        this.title = title;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public int getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(int vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(int rackNumber) {
        this.rackNumber = rackNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
