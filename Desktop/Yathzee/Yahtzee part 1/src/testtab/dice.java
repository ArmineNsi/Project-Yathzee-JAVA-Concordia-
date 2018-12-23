/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtab;        //CLASS DICE
import java.util.Random;
/**
 *
 * @author Nicolas
 */
class dice {
    int number;         //Number of the dice
    int id;             //id 
    public dice(int id)     //constructor
    {
    Random rn = new Random();
    number = rn.nextInt(6) +1;
    this.id = id;
    }
    public void printid()           //print the id of the dice
    {
   System.out.println("votre id est" +id);
    }
    
    public int getNumber()          //getter to collect the number of the dice bc it is in private
    {
    return number;
    }
    
    public void printNumber()           //print the number of the dice
    {
    System.out.println("Number: " + number);
    }
    
    public void launch()            //launch the number of the dice for all tour 
    {
    Random r = new Random();
    number = r.nextInt(6) +1;
    }
    
}
