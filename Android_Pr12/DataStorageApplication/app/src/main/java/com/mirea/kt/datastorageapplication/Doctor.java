package com.mirea.kt.datastorageapplication;

public class Doctor {
    private String Name;
    private String specialty;
    private int certificationFlag;

    public Doctor(String name, String specialty, int certificationFlag) {
        Name = name;
        this.specialty = specialty;
        this.certificationFlag = certificationFlag;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getCertificationFlag() {
        return certificationFlag;
    }

    public void setCertificationFlag(int certificationFlag) {
        this.certificationFlag = certificationFlag;
    }
}
