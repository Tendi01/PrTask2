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
  private String name;
  private String surname;
  
//конструктор класса
  public Doctor(String name, String surname){
    this.name=name; //this используется для обращения к элементам внутри класса и писать в списке аргументов конструктора такие же имена переменных 
    this.surname=surname;
  }
 
  public String getName() { // метод getter для получения значения переменных(имеет доступ к приватным переменным)
    return name;
}
public void setName(String name){ //метод setter для инициализации значений переменных(имеет доступ к приватным переменным)
    this.name=name;
}

public String getSurname() { // метод getter для получения значения переменных(имеет доступ к приватным переменным)
    return surname;
}
public void setSurame(String surname){ //метод setter для инициализации значений переменных(имеет доступ к приватным переменным)
    this.surname=surname;
}

 public String writeRecipe(String recipe){
     return recipe;
}
}
