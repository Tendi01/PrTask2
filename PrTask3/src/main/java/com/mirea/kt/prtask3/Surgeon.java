package com.mirea.kt.prtask3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

 //дочерний класс хирург Surgeon
public class Surgeon extends Doctor{ //наследуется от класса Доктор
    private int cabinet; 

    public Surgeon (int cabinet, String name, int age){
        super(name, age);
        this.cabinet=cabinet;
    }

    @Override
   public void writeRecipe(String recipe){
        recipe = recipe.toRec
   } 
}
