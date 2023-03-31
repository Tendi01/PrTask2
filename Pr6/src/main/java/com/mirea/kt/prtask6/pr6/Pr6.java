/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mirea.kt.prtask6.pr6;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Pr6 {

    public static void main(String[] args) {
    System.out.println("Practical task №6 Variant 3. Student Bursikova T.A. Group RIBO-04-21");
    
    Scanner scan = new Scanner(System.in);
    
    System.out.print("name = ");
    String name = scan.nextLine();
    if (name  == null) {name = "Ivan";}
    System.out.print("surname = ");
    String surname = scan.nextLine();
    if (surname  == null) {name = "Ivanov";}
    System.out.print("age = ");
    int age = scan.nextInt();
    System.out.print("education = ");
    String education = scan.nextLine();
    if (education  == null) {name = "Mirea";}
    System.out.print("experience = ");
    int experience = scan.nextInt();
    Doctor doctor = new Doctor(name, surname, age, education, experience);
    
    SaverRunnable sr = new SaverRunnable(doctor, "C:/doctor.txt");//объект класса severRunnable
    Thread th = new Thread(sr); //создание потока
    th.start();//запуск потока
    }
}

