/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mirea.kt.prtask3;

/**
 *
 * @author User
 */

//Создание объектно-ориентированного приложения для обработки
//строк. Изучение полиморфизма и абстракции на примерах.
import java.util.Scanner;
public class PrTask3 {
    public static void main(String[] args) { //тип void означает, что метод ничего не возвращает
        System.out.println("Practical task №3. Variant 3. Student Bursikova T.A. Group RIBO-04-21 ");
        Scanner scan = new Scanner (System.in);
       
   
        System.out.println( "Which doctor are you? 1 -Surgeon, 2 - Therapist");
        int clas=scan.nextInt();
        System.out.println("Enter name ");
        String name=scan.nextLine(); 
        System.out.println("Enter surname ");
        String surname=scan.nextLine(); 
        System.out.print("Enter: What recipe would you like to write? ");
        String recipe=scan.nextLine(); 
        if (clas==1){
            Doctor doctor = new Surgeon(name, surname);
            System.out.println("Write you: " + doctor.writeRecipe(recipe));
       }else{ 
            Doctor doctor = new Therapist(name, surname);
            System.out.println("Write you: " + doctor.writeRecipe(recipe));
}
}
}
