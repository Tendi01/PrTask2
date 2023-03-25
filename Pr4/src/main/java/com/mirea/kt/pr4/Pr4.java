/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mirea.kt.pr4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
//Создание Java-приложения для работы с коллекциями
public class Pr4 {

    public static void main(String[] args) {
         System.out.println("Practical task №3. Variant 3. Student Bursikova T.A. Group RIBO-04-21\n");
         Scanner scan = new Scanner(System.in);
        
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Mukhin Alexander Petrovich","Therapist",5,20,true));
        doctors.add(new Doctor("Sultanovich Ibragim Osmanovich","Serguon",10,21,true));
        doctors.add(new Doctor("Korovkin Nikolai Abdulaevich","Psychiatrist",25,10,false));
        
        while (true) {
            Collections.sort(doctors);//сортировка коллекции
            for (Doctor doc : doctors) { //расширенныим циклом for отображаем в консоль
                System.out.println(doc.getfullName()+", "+doc.getSpeciality()+", "+doc.getNumber()+", "+doc.getWorkDays() +", "+doc.isAttestated());
            }
            System.out.println("\n Adding new doctor details - 1 \n Changing the certification mark - 2 \n Exit - 0 \n Select function:");
            int function = scan.nextInt();
            if (function == 0) {
                System.out.println("Exit!");
                break;
            }else if (function == 1) {
                System.out.println("Enter full name:");
                String fullName = scan.nextLine();
                System.out.println("Enter specialty:");
                String speciality = scan.nextLine();
                int number=0;
                while (true) {
                    boolean flag = true;
                    System.out.println("Enter individual number:");
                    number = scan.nextInt();
                    for (Doctor d : doctors) {
                        if (d.getNumber() == number) {
                            flag = false;
                            break;
                        }
                    }if (flag) {
                        break;
                    }else {
                        System.out.println("Doctor listed earlier!");
                    }
                }
                System.out.println("Enter working days:");
                int workDays = scan.nextInt();
                System.out.println("Attestation passed. (Put true or false):");
                boolean attestation = scan.nextBoolean();
                doctors.add(new Doctor(fullName, speciality, number, workDays, attestation));//добавляем элемент
            }else if (function == 2) {
                while (true) {
                    System.out.println("Select individual number:");
                    int number = scan.nextInt();
                    boolean flag = true;
                    for (Doctor doc : doctors) {
                        if (doc.getNumber() == number) {
                            doc.changeAttestation(); 
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        System.out.println("There is no individual number! ");
                    }
                    else {
                        break;
                    }
                }
            }
            else {
                System.out.println("No such function!");
            }
        }
    }
}