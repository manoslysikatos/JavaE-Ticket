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
public class Duration {                                         //Thats the class related to all the available tickets
    private int    transportationType;                          //That field will depict the duration of the ticket.Either oneTrip(90 minutes) or oneDay(24 hours)
    private int    numberOfTransportationType;                  //That field will depict the amount of the transportation type.For example, one month ticket is(transportationType=oneDay,numberOfTransportationType=30)
    private String description;                                 //A small description for each ticket
    private float regularPrice;                                 //That field contains the value for the current ticket, with a regular price
    private float decreasedPrice;                               //That field contains the value for the current ticket, with a decreased price  
                                                                //I only use that class in order to make the HashMap that contains all the available options


    public Duration(int Type, int Number, String Description, float regularPrice, float decreasedPrice){
        transportationType = Type;
        numberOfTransportationType = Number;
        this.description = Description;
        this.regularPrice = regularPrice;
        this.decreasedPrice = decreasedPrice;
        //this.Price = Price;
        
    }
    
    /**
     * @return the TransportationType
     */
    public int getTransportationType() {
        return transportationType;
    }

    /**
     * @param TransportationType the TransportationType to set
     */
    public void setTransportationType(int TransportationType) {
        this.transportationType = TransportationType;
    }

    /**
     * @return the NumberOfTransportationType
     */
    public int getNumberOfTransportationType() {
        return numberOfTransportationType;
    }

    /**
     * @param NumberOfTransportationType the NumberOfTransportationType to set
     */
    public void setNumberOfTransportationType(int NumberOfTransportationType) {
        this.numberOfTransportationType = NumberOfTransportationType;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.description = Description;
    }
    
    public float getRegularPrice(){
        return this.regularPrice;
    }
    
    public float getDecreasedPrice(){
        return this.decreasedPrice;
    }
    
}
