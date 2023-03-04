package com.mirea.kt.prtask2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

    //терапевт Therapist
public class Therapist extends Doctor {
    private String workPlace;
    private String experience;
    private int height;

public Therapist ( String workPlace, String experience, int height, String name){
super(name); //вызов конструктора родительского класса
this.workPlace=workPlace;
this.experience=experience;
this.height=height;
}

public String work(String[ ] todoList){
//рабочий выполняет список дел
return "результат";
}
public void lunchEater(int period){
System.out.println("Surgeon goes out for lunch " + period);
}
public void numberOfReceptions(int number){
System.out.println("Surgeon goes out for lunch " + number);
}

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public String getExperience() {
        return experience;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        String str= "name =" + getName() +", workPlace = " + this.workPlace + ", experience = " + this.experience + ", At work = " + this.height;
        return str; //Generated from
    }
}