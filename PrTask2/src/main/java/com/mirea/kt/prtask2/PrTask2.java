/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mirea.kt.prtask2;

/**
 *
 * @author User
 */
import java.util.Scanner;
public class PrTask2 {
    public static void main(String[] args) { //тип void означает, что метод ничего не возвращает
        System.out.println("Practical task №2. Variant 3. Student Bursikova T.A. Group RIBO-04-21 ");
        
        System.out.println( "Object of what class to create? 1 -Surgeon, 2 - Therapist");
        Scanner scan = new Scanner (System.in);
        int clas=scan.nextInt();
        if (clas==1){
            Scanner s = new Scanner (System.in);
            System.out.println("Enter cabinet ");
            int cab=s.nextInt();
            System.out.println("Enter name ");
            String na=s.nextLine(); 
            System.out.println("Enter surname ");
            String surn=s.nextLine(); 
            System.out.println("Enter atWork ");
            boolean work=s.nextBoolean(); 
            System.out.println("Enter age ");
            int a=s.nextInt(); 
            System.out.println("Enter gender ");
            String gen=s.nextLine(); 
            Surgeon surgeon = new Surgeon(cab, na, surn, work, a, gen);
            System.out.println(surgeon.toString());
        }else{ 
            Scanner sc = new Scanner (System.in);
            System.out.println("Enter name ");
            String nam=sc.nextLine();
            System.out.println("Enter height ");
            int hei=sc.nextInt();
            System.out.println("Enter workPlace "); 
            String wPlace=sc.nextLine();
            System.out.println("Enter experience ");
            String experienc=sc.nextLine();
            Therapist therapist = new Therapist(wPlace, experienc, hei, nam);
            System.out.println(therapist.toString());
        }         
}
}
