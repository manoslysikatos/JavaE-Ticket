/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javae.ticket;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author manoslysi
 */
public class Extra extends Ticket{                          //That class depicts the extra tickets.That means that here we have the decreased tickets and the regular monthly tickets
    private String name;                                    //Extra ticket is a subclass of the ticket class
    private String password;
    private String expirationDate;
    
    public Extra(String Name, String Password, Duration Transport,boolean isDecreased){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();                                          //That's something I found in a forum.Here i wanted to add the days for each ticket, provided the current date and time
        String ExpirationDate;                                                          //URL:https://stackoverflow.com/questions/428918/how-can-i-increment-a-date-by-one-day-in-java
        this.name = Name;
        this.password = Password;
        this.transport = Transport;
        if(Transport.getTransportationType() == 1440){
            cal.add(Calendar.DAY_OF_MONTH, Transport.getNumberOfTransportationType());
            this.expirationDate = df.format(cal.getTime());
        }else if(Transport.getTransportationType() == 90){                             //If we have any oneTrip ticket, the expiration date will depict the expiration date of the first ticket(currentTime+90 minutes)
            cal.add(Calendar.MINUTE, 90);
            this.expirationDate = df.format(cal.getTime());
        }  
        this.transport = Transport;
        if(isDecreased){
            this.isDecreased = true;
            this.price = Transport.getDecreasedPrice();
        }else{
            this.isDecreased=false;
            this.price = Transport.getRegularPrice();
        }
    }
    public String getDescription(){
        return this.transport.getDescription();
    }
    
    public int getTransportationtType(){
        return this.transport.getTransportationType();   
    }
    
    public int getDaysOrTranspots(){
        return this.transport.getNumberOfTransportationType();
    }
    
    public String getName(){
        return name;
    }
    
    public String getExpirationDate(){
        return expirationDate;
    }
    
    public void extendExpirationDate(int moreDays){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String ExpirationDate;
        cal.add(Calendar.DAY_OF_MONTH, moreDays);
        this.expirationDate = df.format(cal.getTime());
    }
    
}
