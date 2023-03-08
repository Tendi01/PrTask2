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

public Therapist ( String name, String surname){
    super(name,surname);//вызов конструктора родительского класса
} 

@Override
public String writeRecipe(String recipe){
       String reversed = new StringBuffer(recipe).reverse().toString();//метод развертывания текста
      return  reversed;
}
}