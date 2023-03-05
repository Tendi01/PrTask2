package com.mirea.kt.prtask3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

public class Doctor {
  String name;
  private int age;
  
//конструкторы класса
  public Doctor(String name){
    this.name=name;
  }
  public Doctor(String name, int age){
    this.name=name; //this используется для обращения к элементам внутри класса и писать в списке аргументов конструктора такие же имена переменных 
    this.age=age;
  }

  //метод класса
  public void writeRecipe(String recipe){
   
  }
  
  public String getName() { // метод getter для получения значения переменных(имеет доступ к приватным переменным)
    return name;
}
public void setName(String name){ //метод setter для инициализации значений переменных(имеет доступ к приватным переменным)
    this.name=name;
}

public int getAge(){
    return age;
}
public void setAge(int age){
    if (age<0 || age>100){
        this.age=48;
    }else{
        this.age=age;
}
}

    Doctor toUpperCase() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
