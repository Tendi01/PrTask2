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
public class Surgeon extends Doctor{ //класс Sergeon расширяет класс Doctor

    public Surgeon (String name, String surname){
        super(name,surname);
    }

    @Override
   public String writeRecipe(String recipe){
       recipe=recipe.toUpperCase();//преобразование символов в заглавные буквы
      return  recipe;
   }
  /** @Override
    public String toString(){
        return recipe;
    } 
  */
}
