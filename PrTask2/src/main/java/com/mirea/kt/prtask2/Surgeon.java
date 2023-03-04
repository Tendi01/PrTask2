package com.mirea.kt.prtask2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

 //хирург Surgeon

public class Surgeon extends Doctor{ //наследуется от класса Доктор
    private int cabinet; 
    private String surname;//отчество
    boolean atWork;

    public Surgeon (int cabinet, String name, String surname, boolean atWork,  int age, String gender){
        super(name, age, gender);
        this.cabinet=cabinet;
        this.surname=surname;
        this.atWork=atWork;
    }

    public void goesToFloor(int floor){
        System.out.println("Surgeon goes to " + floor);
    }
    public void advises(String youhave){
        System.out.println("You have a " + youhave);
    }
    public void treatsWounds(String medicament){
        System.out.println("treats wounds " + medicament);
    }

    public void setCabinet(int cabinet) {
        this.cabinet = cabinet;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAtWork(boolean atWork) {
        this.atWork = atWork;
    }

    public int getCabinet() {
        return cabinet;
    }

    public String getSurname() {
        return surname;
    }
    public boolean isAtWork() {
        return atWork;
    }

 
    @Override
    public String toString(){
        return "Surgeon name = " + getName() + ", age = " + getAge() + ", gender=" + getGender() +", cabinet = " + this.cabinet + ", surname = " + this.surname + ", At work = " + this.atWork;
    } 
}
