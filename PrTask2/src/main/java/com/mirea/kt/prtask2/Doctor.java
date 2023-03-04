/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mirea.kt.prtask2;

/**
 *
 * @author User
 */
public class Doctor{
    //пересенные класса
  String name;
  private int age;
  private String gender;
  
//конструкторы класса
  public Doctor(String name){
    this.name=name;
  }
  public Doctor(String name, int age, String gender){
    this.name=name; //this используется для обращения к элементам внутри класса и писать в списке аргументов конструктора такие же имена переменных 
    this.age=age;
    this.gender=gender;
  }

  //методы класса
  public void startWorking(int hours){
    System.out.println("Doctor starts working " + hours + " a.m.");
  }
  public void prescribe(String tablets){
    System.out.println("Doctor prescribe " + tablets + "tablet");
  }
  public void writesDownTheDisease(String disease){
    System.out.println("Doctor writes down the disease " + disease + "tablet");
  }

public String getName() { // метод getter для получения значения переменных(имеет доступ к приватным переменным)
    return name;
}
public void setName(String name){ //метод setter для инициализации значений переменных(имеет доступ к приватным переменным)
    this.name=name;
}
public String getGender() {
    return gender;
    }

public void setGender(String gender) {
    this.gender = gender;
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

}

