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
public class ListOfDurationOptions {
    
    /*
        Here i just create and initialize a HashMap that contains all the available options about tickets.
        The HashMap will be initialized like that:
    
        1 -> (90,1,"One Transportation")
        2 -> (90,5,"Five Transportations")
        3 -> (90,11,"10+1 Transportations")
        4 -> (1440,1,"One Day Trip")
        5 -> (1440,5,"One Week Trip")
        6 -> (1440,40,"One Month Trip")
    
        P.S. The first value of Duration depicts the minutes.
             The second value depicts the amount of the first value
             The third value is a small Description
             The fourth value is the regular price of the ticket
             The fifth value is the decreased price ot the ticket
             The HashMap will contain objects from the class Duration
    
    */    
    HashMap<Integer,Duration> hmap;
    
    public ListOfDurationOptions(){
        int oneTrip = 90;                       //in minutes
        int oneDay = 1440;                      //in minutes
        hmap = new HashMap<Integer,Duration>();
        Duration duration1 = new Duration(oneTrip,1,"One Transportation",1.40f,0.6f);
        Duration duration2 = new Duration(oneTrip,5,"Five Transportations",6.5f,3f);
        Duration duration3 = new Duration(oneTrip,11,"10+1 Transportations",13.5f,6f);
        Duration duration4 = new Duration(oneDay,1,"One Day Trip",4.5f,4.5f);
        Duration duration5 = new Duration(oneDay,5,"One Week Trip",9f,9f);
        Duration duration6 = new Duration(oneDay,30,"One Month Trip",30f,15f);
        hmap.put(1,duration1);
        hmap.put(2,duration2); 
        hmap.put(3,duration3);
        hmap.put(4,duration4);
        hmap.put(5, duration5);
        hmap.put(6, duration6);
        
    }
    
    public HashMap<Integer,Duration> getListOfDurationOptions(){
        return hmap;
    }
}
