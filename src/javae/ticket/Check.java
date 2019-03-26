/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javae.ticket;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author manoslysi
 */
public class Check {                                    //Thats a class i made in order to check every time if the user enters a valid option 
    
    public int makeCheck(int[] availableOptions, String ErrorMessage, String ErrorMessage2){
        int test;
        Scanner scan =new Scanner(System.in);
        try{
            test = scan.nextInt();
        }catch(InputMismatchException e){
            System.out.println(ErrorMessage);
            System.out.println("=====================");
            return -1;
        }
        
        for(int i=0;i<availableOptions.length;i++){
            if(availableOptions[i] == test){
                return test;
            }
        }
        System.out.println(ErrorMessage2);
        System.out.println("=====================");
        return -1;
    }
}
