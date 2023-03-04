package com.mirea.kt.practicaltask1;

import java.util.Scanner;
public class PrTask1 {
    public static void main(String[] args) {
        System.out.println("Practical task №1. Variant 3. Student Bursikova T.A. Group RIBO-04-21 ");
        System.out.println("Please, enter int value: ");
        Scanner scan = new Scanner (System.in);
        int rangeStart=scan.nextInt();
        int rangeEnd=scan.nextInt();
        if (rangeStart<100 || rangeStart>999 && rangeEnd<100 || rangeEnd>999){
            System.out.print( "Error: invalid value ");
        }else{
            for (int i=rangeStart; i<=rangeEnd; i++){
                if (i%2==0){
                   System.out.print(" Even number-" +i);
                }else{
                   System.out.print(" Odd number-"+i);
                }
            }
        }

    }
}
