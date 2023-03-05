package com.mirea.kt.prtask3;

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

public Therapist ( String workPlace, String name){
super(name); //вызов конструктора родительского класса
this.workPlace=workPlace;
}

public void setWorkPlace(String workPlace) {
    this.workPlace = workPlace;
}
public void writeRecipe(Doctor recipe){
recipe = recipe.toUpperCase();
}
}