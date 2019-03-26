/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javae.ticket;

import java.util.Scanner;

/**
 *
 * @author manoslysi
 */
public class Payment {
    int euros;
    float eurosInFloat;
    int decimals;
    
    public boolean startPayment(){                      //That class is about the payment after the user has made his/her choice
        String errorMessage;                            //In the case that user choices to pay in cash, I have just made it to print a message to enter the money and after that a succeful message
        String errorMessage2;
        int paymentMethod;
        Check check = new Check();
        Scanner scan = new Scanner(System.in);
        do{
                        System.out.println("Press:");
                        System.out.println("(1). To pay in cash");
                        System.out.println("(2). To pay with a credit card");
                        System.out.println("(3). Exit");
                        System.out.print("So, what would you like to do?: ");
                        int[] availableOptions = {1,2,3}; 
                        errorMessage = "Oooops, it seems like you didn't enter neither of the choices.I know it wasn't on purpose.Please try again";
                        errorMessage2 = "Oooops!! That's an invalid payment method.Please try again";
                        paymentMethod = check.makeCheck(availableOptions, errorMessage, errorMessage2);
                        
                    }while(paymentMethod != 1 && paymentMethod !=2 && paymentMethod != 3);
                    System.out.println("=====================");
                    if(paymentMethod == 3){
                        return false;
                    }else if(paymentMethod == 1){
                        System.out.println("Please enter the money in the slot");
                        System.out.println("Successful Payment.Thank you very much");
                        return true;
                    }else if(paymentMethod == 2){
                        String email = new String();
                        do{
                        System.out.print("Please enter your email: ");
                        email = scan.nextLine();
                        }while(!email.contains("@"));
                        System.out.println("We just send a confirmation to " + email +".Thank you very mych!!");   
                        return true;
                    }
                  
         return false;
    }
    
}
