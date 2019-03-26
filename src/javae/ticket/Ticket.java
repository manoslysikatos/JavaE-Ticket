/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javae.ticket;

/**
 *
 * @author manoslysi
 */
public class Ticket {                                       //Ticket is a general class, that every object-ticket will have
    protected boolean isElectronic;                         //I have set the fields as protected in order class "Extra" can access those fields when necessary
    protected boolean isDecreased;
    protected Duration transport;
    protected float price;
    
    public Ticket(){
    }
    
    public Ticket(Duration transport){
        isDecreased = false;
        this.transport = transport;
        this.price = this.transport.getRegularPrice();
    }
    
    public void setIsElectronic(boolean isElectronic){
        this.isElectronic = isElectronic;
    }
    public Duration getTransport(){
        return transport;
    }
    
    public String getIsElectronic(){
        if(isElectronic){
            return "Electronic";
        }else{
            return "Paper";
        }
        
    }
    
    public boolean getIsDecreased(){
        return isDecreased;
    }
}
