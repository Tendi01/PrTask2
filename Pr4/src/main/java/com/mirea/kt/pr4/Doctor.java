/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mirea.kt.pr4;

/**
 *
 * @author user
 */
public class Doctor implements Comparable<Doctor>{
    private String fullName;
    private String speciality;
    private int number;
    private int workDays;
    private boolean attestation;

    public Doctor(String fullName, String speciality, int number, int workDays, boolean attestation) {
        this.fullName = fullName;
        this.speciality = speciality;
        this.number = number;
        this.workDays = workDays;
        this.attestation = attestation;
    }
    
    @Override
    public int compareTo (Doctor doc) {
        return fullName.compareTo(doc.getfullName());
    }
    
    public String getfullName() {
        return this.fullName;
    }
    public String getSpeciality() {
        return this.speciality;
    }
    public int getNumber() {
        return this.number;
    }
    public int getWorkDays() {
        return this.workDays;
    }
    public boolean isAttestated() {
        return this.attestation;
    }
    
    public void setfullName(String fullName) {
        this.fullName = fullName;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }
    public void setAttestation(boolean attestation) {
        this.attestation = attestation;
    }
    
    public void changeAttestation() {
        this.setAttestation(!this.isAttestated());
    }
}
