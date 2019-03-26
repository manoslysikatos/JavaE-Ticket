/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javae.ticket;

import java.util.HashMap;

/**
 *
 * @author manoslysi
 */
public class UpdateTicket {                             //That's a class about the Update od a ticket(option 2 in the main menu)
    int updatedTicket;                                  //The user can only update his/her ticket with a duration od the same type(oneTrip/oneDay)
    int updatedExtra;                                   
    public UpdateTicket(Ticket ticket){
        String errorMessage,errorMessage2;
        int option;
        Check check = new Check();
        ListOfDurationOptions hmap = new ListOfDurationOptions();
        HashMap<Integer,Duration> list = hmap.getListOfDurationOptions();
        System.out.println("[" + ticket.getTransport().getDescription() +"]");
        if(ticket.getTransport().getTransportationType() == 90){    //Transportations
            do{
            System.out.println("Choose duration:");
            for(int i=1;i<4;i++){
                    System.out.println("(" +i + "). " + " " +list.get(i).getDescription());
            }
            System.out.println("(4). Back");
            System.out.print("So what would you like to buy?: ");
            int[] availableOptions = {1,2,3,4};
            errorMessage = "Oooops, it seems like you didn't enter none of those choices.I know it wasn't on purpose.Please try again";
            errorMessage2 = "Oooops!! You didn't enter none of those choices.Come on, try again!";
            option = check.makeCheck(availableOptions,errorMessage, errorMessage);
            }while(option !=1 && option !=2 && option!=3 && option!=4);
            if(option != 4){
                System.out.println("=======Your Updated Ticket=======");
                System.out.println("Description: " +ticket.transport.getDescription());
                int total =list.get(option).getNumberOfTransportationType()+ticket.getTransport().getNumberOfTransportationType();
                System.out.println("Total Transportations After The Purchase: " +total);
                if(ticket.getIsDecreased()){
                    System.out.println("Price: " +list.get(option).getDecreasedPrice() +"€");
                }else{
                    System.out.println("Price: " +list.get(option).getRegularPrice()+"€");
                }
                    System.out.println("=========================");
                Payment pay = new Payment();
                if(pay.startPayment()){
                    updatedTicket = total;
                }else{
                    updatedTicket = ticket.getTransport().getNumberOfTransportationType();
                }
                
            }
            
         }else if(ticket.getTransport().getTransportationType()==1440){
            do{
            System.out.println("Choose days:");
            for(int i=1;i<4;i++){
                    System.out.println("(" +i + "). " + " " +list.get(i+3).getDescription());
            }
            System.out.println("(4). Back");
            System.out.print("So what would you like to buy?: ");
            int[] availableOptions = {1,2,3,4};
            errorMessage = "Oooops, it seems like you didn't enter none of those choices.I know it wasn't on purpose.Please try again";
            errorMessage2 = "Oooops!! You didn't enter none of those choices.Come on, try again!";
            option = check.makeCheck(availableOptions,errorMessage, errorMessage);
            }while(option !=1 && option !=2 && option!=3 && option!=4);
            if(option != 4){
                //ticket.getTransport().setNumberOfTransportationType(list.get(option).getNumberOfTransportationType());
                System.out.println("=======Your Updated Ticket=======");
                System.out.println("Description: " +ticket.transport.getDescription());
                int total =list.get(option+3).getNumberOfTransportationType()+ticket.getTransport().getNumberOfTransportationType();
                System.out.println("Total Days After The Purchase: " +total);
                if(ticket.getIsDecreased()){
                    System.out.println("Price: " +list.get(option+3).getDecreasedPrice() +"€");
                }else{
                    System.out.println("Price: " +list.get(option+3).getRegularPrice() +"€");
                }
                System.out.println("=========================");
                Payment pay = new Payment();
                if(pay.startPayment()){
                    updatedTicket = total;
                }else{
                    updatedTicket = ticket.getTransport().getNumberOfTransportationType();
                }
            }
            
        }
    }
    
    public void UpdateTicket(Extra extra){
        
    }
    
    public int getUpdatedTicket(){
        return updatedTicket;
    }
}
