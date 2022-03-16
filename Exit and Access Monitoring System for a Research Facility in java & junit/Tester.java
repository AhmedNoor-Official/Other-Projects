import java.util.*;
/**
 * Write a description of class OTester here.
 * 
 * @author 
 * @version 
 */
public class Tester 
{   
    
    private Scanner reader = new Scanner(System.in);
    private CREAM corona = new Institute();
    private Teamwork tw=new Teamwork();  

    private void doTest()
    {
        // write your tests here
        
        /*displaying Team Name and Members*/
        
        tw.displayDetails();
        
        
        /*Showing all Passes in All Rooms*/
        System.out.println("\n\n********************ALL Passes In All Rooms*****************************");
        System.out.println(corona.getAllPassesInAllRooms());
        
        /*Showing Location of Pass 1001*/
        System.out.println("\n\n********************Showing Location Of Pass 1001*****************************");
        int loc=corona.findPass(1001);
        if( loc!=-1)
        System.out.println("The location of pass 1001 is in room number..."+loc);
        else
        System.out.println("The Pass ID is not valid!");
           
        
        /*Showing an invalid pass number*/
        System.out.println("\n\n********************Showing Location Of Pass 1101*****************************");
        int loc2=corona.findPass(1101);
        if( loc2!=-1)
        System.out.println("The location of pass 1001 is in room number..."+loc2);
        else
        System.out.println("The Pass ID is not valid!");
        
        //Setting All Passes to outside
        
        //corona.evacuateAll();
        
        
        
        /*Showing All Passes in outside*/
        System.out.println("\n\n********************Showing All Passes Outside*****************************");
        System.out.println(corona.getAllPassesInRoom(100));
        
        
        /*move a pass to another room*/
        System.out.println(corona.move(1000,0));
        
        
        //check the location of Pass Number 1000*/
        System.out.println("********************Showing Location Of Pass 1000 After Move *****************************");
        int loc3=corona.findPass(1000);
        if( loc3!=-1)
        System.out.println("The location of pass 1000 is in room number..."+loc3);
        else
        System.out.println("The Pass ID is not valid!");
        
        
        
        
        
        
        
        /*Showing the Passes of Room 101*/
        
        
        
        System.out.println("********************Showing All Passes In Staff Room After Move****************************");
        System.out.println(corona.getAllPassesInRoom(101));
        
        /*Reset the Pass no 1004*/
        
        //System.out.println("********************Resetting Pass 1004****************************");
        //corona.resetPass(1004);
        
    
        
       
        /*Showing Pass 1004 after Reset*/
        System.out.println("\n\n********************Showing Pass 1004****************************");
        System.out.println(corona.showPass(1004));
        
        
        //Moving a Pass 1007 to outside*/
        System.out.println("\n\n********************Moving Pass 1007 Outside****************************");
        corona.moveOutside(1007);
        
        
        
        //Moving All Passes to OutSide
        System.out.println("\n\n******************** Emergency Exit of All Passes ****************************");
        corona.evacuateall();
        
        
        
        
      
        
        
        
        
        
        
        
        
        
        
    
        
        
        

    
    }
     
    
    public static void main(String[] args)
    {
        Tester xx = new Tester();
        xx.doTest();
    }
}
