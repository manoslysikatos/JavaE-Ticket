/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javae.ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author manoslysi
 */
public class Menu {
    private int[] options = new int[2];
    private String errorMessage;
    private String errorMessage2;
    private Check check;
    List<Ticket> allRegularTickets = new ArrayList();                           //That list contains all the regular tickets meaning it has all the ticket except those with month duration and the decreased ones
    List<Extra> allExtraTickets = new ArrayList();                              //That list contains all the extra tickets, meaning those that have month duration and the decreased ones 
    boolean exit=false;
    int option;
    public Menu(){                                                                      //Displays the main options
        ListOfDurationOptions hm = new ListOfDurationOptions();                         //I Load all the options from the HashMap i have made
        HashMap<Integer,Duration> myList = hm.getListOfDurationOptions();
        Ticket defaultTicket1 = new Ticket(myList.get(5));
        defaultTicket1.setIsElectronic(true);
        Extra defaultTicket2 = new Extra("Manos","21734",myList.get(3),true);
        defaultTicket2.setIsElectronic(false);
        Extra defaultTicket3 = new Extra("Lysikatos", "21734", myList.get(6),false);
        defaultTicket3.setIsElectronic(true);
        allRegularTickets.add(defaultTicket1);
        allExtraTickets.add(defaultTicket2);
        allExtraTickets.add(defaultTicket3);
        boolean exitSignal=false;
        do{                                                                         //Thats the main menu, the users exits only if he comes to that menu and press 4
        System.out.println("==========Welcome==========");
        option=0;
        options[0] = 0;
        options[1] = 0;
        int i;
        do{
            System.out.println("Press:");
            System.out.println("(1). If you want a new ticket");
            System.out.println("(2). If you want to update an existing one");
            System.out.println("(3). If you want to show information");
            System.out.println("(4). If you want to exit");
            System.out.print("So,What would you like to do?: ");
            Check check = new Check();                                              //In order not to repeat myself, i have created a class that takes an input and messages that i have as parameters.So if the user enters and invalid type(for example a char) or an invalid option, there will be a separate message each time
            int[] availableOptions = {1,2,3,4};
            errorMessage = "Ooops!! It seems like you didn't enter one of those four choices.I know it wasn't on purpose.Please try again!";
            errorMessage2 = "Oooops!! You didn't enter none of the four choices.Come on, try again!";
            option = check.makeCheck(availableOptions, errorMessage, errorMessage2);   
        }while(option != 1 && option!=2 && option!=3 && option!=4);
        System.out.println("===========================");
        if(option != 4){
            subMenu(option);
        }else{
            System.out.println("It was nice to meet you.Have a nice day.Byeee!!!");
            exitSignal = true;
        }
        }while(exitSignal==false);
    }
    
    private void subMenu(int option){                                               //Displays the options after the initial menu.Type of ticket etc
        if(option == 1){
            while(options[0]!= 1 && options[0] != 2 && options[0]!=3){
                System.out.println("Press:");
                System.out.println("(1). For a regular price ticket");
                System.out.println("(2). For a decreased price ticket");
                System.out.println("(3). Back");
                System.out.print("So,What would you like?: ");
                check = new Check();
                int[] availableOptions = {1,2,3};
                errorMessage = "Ooops!! It seems like you didn't enter one of those two choices.I know it wasn't on purpose.Please try again!";
                errorMessage2 =  "Oooops!! You didn't enter none of the three choices.Come on, try again!";
                options[0] = check.makeCheck(availableOptions,errorMessage,errorMessage2);  
            }
            System.out.println("=====================");
            if(options[0] != 3){
                handleOptions(options);
            }
        }else if(option == 2){
            int i,z;
            int subOption,type;
            int allChoices = allRegularTickets.size() + allExtraTickets.size();
            int[] availableOptions2 = new int[allChoices];
            
       do{     
            System.out.println("=======Available Tickets=======");                  //Here the user can check all the available tickets(including both those that are already made by me and those that user creates)
            for(i=0;i<allRegularTickets.size();i++){
                System.out.println("("+(i+1)+"). " +allRegularTickets.get(i).getTransport().getDescription());
            }
            for(int j=0;j<allExtraTickets.size();j++){
                System.out.println("("+(i+1)+"). " +allExtraTickets.get(j).getTransport().getDescription());
                i++;
            }
            System.out.print("Which ticket would you like to update?: ");
            check = new Check();
            for(z=0;z<allChoices;z++){
                availableOptions2[z] = z+1;
            }
            errorMessage = "Ooops!! It seems like you didn't enter one of those two choices.I know it wasn't on purpose.Please try again!";
            errorMessage2 =  "Oooops!! You didn't enter none of the three choices.Come on, try again!";
            subOption = check.makeCheck(availableOptions2,errorMessage,errorMessage2);
        }while(subOption==-1);
            System.out.println("=====================");
            if(subOption <= allRegularTickets.size()){                  //some calculations in order to understand in which ticket user is referring to.If it enters that if, it means each one ticket in the allRegularTicket list
               subOption -= 1;
               UpdateTicket updateTicket = new UpdateTicket(allRegularTickets.get(subOption));
               allRegularTickets.get(subOption).getTransport().setNumberOfTransportationType(updateTicket.getUpdatedTicket());
            }else{                                                      //if it enters here, it means it's a ticket from the allExtraTickets list
               subOption  -= (allRegularTickets.size()+1);
               //System.out.println(allExtraTickets.get(subOption).getDescription());
               UpdateTicket updateTicket = new UpdateTicket(allExtraTickets.get(subOption));
               allExtraTickets.get(subOption).getTransport().setNumberOfTransportationType(updateTicket.getUpdatedTicket());
               if(allExtraTickets.get(subOption).getTransportationtType() == 1440){
                   allExtraTickets.get(subOption).extendExpirationDate(updateTicket.getUpdatedTicket());
               }
            }
        }else if(option == 3){                                      //That options displays all the available tickets from the two lists
            System.out.println("=======Available Tickets=======");
            int i;
            for(i=0;i<allRegularTickets.size();i++){
                System.out.println("*********************");
                System.out.println("Description: "  +allRegularTickets.get(i).getTransport().getDescription());
                System.out.println("Type: Regular");
                System.out.println("Form: " +allRegularTickets.get(i).getIsElectronic());
                System.out.println("Transportations/Days: " +allRegularTickets.get(i).getTransport().getNumberOfTransportationType());
                System.out.println("*********************");
                
            } 
            for(i=0;i<allExtraTickets.size();i++){
                System.out.println("*********************");
                System.out.println("Description: " +allExtraTickets.get(i).getDescription());
                if(allExtraTickets.get(i).getIsDecreased()){
                    System.out.println("Type: Decreased");
                }else{
                    System.out.println("Type: Regular");
                }
                System.out.println("Name: " +allExtraTickets.get(i).getName());
                System.out.println("Expiration Date: " +allExtraTickets.get(i).getExpirationDate());
                System.out.println("Form: " +allExtraTickets.get(i).getIsElectronic());
                System.out.println("Transportations/Days: " +allExtraTickets.get(i).getDaysOrTranspots());
                System.out.println("*********************");
            }
            System.out.println("=====================");
        }else if(option == 4){
            exit=true;
        }
    
    
    }
    
   
    
    private void handleOptions(int[] options){                                  //That's also another method that submenu() only calls, if the user has made the first option, in order to buy a duration
        ListOfDurationOptions hmap = new ListOfDurationOptions();               //i have made the int[] options, in order to make it easier after that to make the ticket
        HashMap<Integer,Duration> list = hmap.getListOfDurationOptions();
            do{
            System.out.println("Choose duration:");
            for(int i=1;i<7;i++){
                    System.out.println("(" +i + "). " +list.get(i).getDescription());
                }
            System.out.println("(7). Back");
            System.out.print("So what would you like to buy?: ");
           // while(options[1]!= 1&&options[1]!=2&&options[1]!=3&&options[1]!=4&&options[1]!=5&&options[1]!=6&&options[1]!=7){
                check = new Check();
                int[] availableOptions = {1,2,3,4,5,6,7};
                errorMessage = "Oooops, it seems like you didn't enter one of those choices.I know it wasn't on purpose.Please try again";
                errorMessage2 = "Oooops!! You didn't enter none of those choices.Come on, try again!";
                options[1] = check.makeCheck(availableOptions, errorMessage, errorMessage2);
            }while(options[1]!= 1&&options[1]!=2&&options[1]!=3&&options[1]!=4&&options[1]!=5&&options[1]!=6&&options[1]!=7);
            if(options[0]==2){
                String Name,Password;
                System.out.print("Please Enter Name: ");
                Scanner scan = new Scanner(System.in);
                while(true){
                    try{
                        Name = scan.nextLine();
                    }catch(Exception e){
                        System.out.println("Well, that's awkward but something went terribly wrong.Please try again");
                        continue;
                    }
                    System.out.println("Please enter a password");
                    try{
                        Password = scan.nextLine();
                    }catch(Exception E){
                        System.out.println("Error!! Unable to save that password.Please try again");
                        continue;
                    }
                    break;
                }
                int optionIsElectronic;
                do{
                System.out.println("=====================");
                System.out.println("Last but not least, press: ");
                System.out.println("(1). For a paper ticket");
                System.out.println("(2). For an electronic ticket");
                System.out.println("So, what would you like to choose?: ");
                int[] availableOptions = {1,2};
                errorMessage = "Oooops, it seems like you didn't enter one of those choices.I know it wasn't on purpose.Please try again";
                errorMessage2 = "Oooops!! You didn't enter none of those choices.Come on, try again!";
                optionIsElectronic = check.makeCheck(availableOptions, errorMessage, errorMessage2);
                }while(optionIsElectronic!=1 && optionIsElectronic!=2);
                    ListOfDurationOptions hm = new ListOfDurationOptions();
                    HashMap<Integer,Duration> myList = hm.getListOfDurationOptions();
                    Extra newTicket = new Extra(Name,Password,myList.get(options[1]),true);
                    if(optionIsElectronic==2){
                        String email;
                        do{
                        System.out.print("Please enter your email: ");
                        email = scan.nextLine();
                        }while(!email.contains("@"));       //The input must contain @
                        System.out.println("After payment we will sent your ticket to " +email);
                        newTicket.setIsElectronic(true);
                    }else{
                        newTicket.setIsElectronic(false);
                    }
                    System.out.println("=======Your Ticket=======");
                    System.out.println("Description: " +newTicket.transport.getDescription());
                    if(newTicket.getIsDecreased()){
                        System.out.println("Type: Decreased");
                    }else{
                        System.out.println("Type: Regular");
                    }
                    System.out.println("Form: " +newTicket.getIsElectronic());
                    System.out.println("Quantity(Transportations/Days): " +newTicket.transport.getNumberOfTransportationType());
                    System.out.println("Expiration Date: " +newTicket.getExpirationDate());
                    System.out.println("Price: " +newTicket.price+"€");
                    System.out.println("=========================");
                    Payment pay = new Payment();
                    if(pay.startPayment()){
                        allExtraTickets.add(newTicket);
                    }
                    
        }else if(options[0]==1 && options[1]!=6){                                   //Regular Tickets except month 
            Scanner scan = new Scanner(System.in);
            int optionIsElectronic;
            do{
                System.out.println("=====================");
                System.out.println("Last but not least, press: ");
                System.out.println("(1). For a paper ticket");
                System.out.println("(2). For an electronic ticket");
                System.out.println("So, what would you like to choose?: ");
                int[] availableOptions = {1,2};
                errorMessage = "Oooops, it seems like you didn't enter one of those choices.I know it wasn't on purpose.Please try again";
                errorMessage2 = "Oooops!! You didn't enter none of those choices.Come on, try again!";
                optionIsElectronic = check.makeCheck(availableOptions, errorMessage, errorMessage2);
            }while(optionIsElectronic!=1 && optionIsElectronic!=2);
            ListOfDurationOptions hm = new ListOfDurationOptions();
            HashMap<Integer,Duration> myList = hm.getListOfDurationOptions();
            Ticket newTicket = new Ticket(myList.get(options[1]));
            if(optionIsElectronic ==2){
                String email;
                        do{
                        System.out.print("Please enter your email: ");
                        email = scan.nextLine();
                        }while(!email.contains("@"));
                        System.out.println("After payment we will sent your ticket to " +email);
                newTicket.setIsElectronic(true);
            }else{
                newTicket.setIsElectronic(false);
            }
            System.out.println("=======Your Ticket=======");
            System.out.println("Description: " +newTicket.transport.getDescription());
            if(newTicket.getIsDecreased()){
               System.out.println("Type: Decreased");
            }else{
               System.out.println("Type: Regular");
            }
            System.out.println("Form: " +newTicket.getIsElectronic());
            System.out.println("Quantity(Transportations/Days): " +newTicket.transport.getNumberOfTransportationType());
            System.out.println("Price: " +newTicket.price +"€");
            System.out.println("=========================");
            Payment pay = new Payment();
            if(pay.startPayment()){
                allRegularTickets.add(newTicket);
            }
        }else if(options[0]==1 && options[1]==6){
             String Name,Password;
                System.out.print("Please Enter Name: ");
                Scanner scan = new Scanner(System.in);
                while(true){
                    try{
                        Name = scan.nextLine();
                    }catch(Exception e){
                        System.out.println("Well, that's awkward but something went terribly wrong.Please try again");
                        continue;
                    }
                    System.out.println("Please enter a password");
                    try{
                        Password = scan.nextLine();
                    }catch(Exception E){
                        System.out.println("Error!! Unable to save that password.Please try again");
                        continue;
                    }
                    break;
                }
                int optionIsElectronic;
                do{
                System.out.println("=====================");
                System.out.println("Last but not least, press: ");
                System.out.println("(1). For a paper ticket");
                System.out.println("(2). For an electronic ticket");
                System.out.println("So, what would you like to choose?: ");
                int[] availableOptions = {1,2};
                errorMessage = "Oooops, it seems like you didn't enter one of those choices.I know it wasn't on purpose.Please try again";
                errorMessage2 = "Oooops!! You didn't enter none of those choices.Come on, try again!";
                optionIsElectronic = check.makeCheck(availableOptions, errorMessage, errorMessage2);
                }while(optionIsElectronic!=1 && optionIsElectronic!=2);
                    ListOfDurationOptions hm = new ListOfDurationOptions();
                    HashMap<Integer,Duration> myList = hm.getListOfDurationOptions();
                    Extra newTicket = new Extra(Name,Password,list.get(options[1]),false);
                    if(optionIsElectronic ==2){
                        String email;
                        do{
                        System.out.print("Please enter your email: ");
                        email = scan.nextLine();
                        }while(!email.contains("@"));
                        System.out.println("After payment we will sent your ticket to " +email);
                        newTicket.setIsElectronic(true);
                    }else{
                        newTicket.setIsElectronic(false);
                    }
                    System.out.println("=======Your Ticket=======");
                    System.out.println("Description: " +newTicket.transport.getDescription());
                    if(newTicket.getIsDecreased()){
                        System.out.println("Type: Decreased");
                    }else{
                        System.out.println("Type: Regular");
                    }
                    System.out.println("Form: " +newTicket.getIsElectronic());
                    System.out.println("Quantity(Transportations/Days): " +newTicket.transport.getNumberOfTransportationType());
                    System.out.println("Expiration Date: " +newTicket.getExpirationDate());
                    System.out.println("Price: " +newTicket.price +"€");
                    System.out.println("=========================");
                    Payment pay = new Payment();
                    if(pay.startPayment()){
                        allExtraTickets.add(newTicket);
                    }
        }
    } 
    
    public boolean getExit(){
        return exit;
    }
    
}
