import java.util.*;
/**
 * Each room has a name,  a protection rating, and a capacity which represents 
 * the maximum number of people(passes) who can be on the room at any one time. Each 
 * room must maintain a list of all people (passes)currently on the room. These lists 
 * are updated whenever passes enter or leave a room,so that it is always possible 
 * to say how many people (passes) are on the room and who they are.
 * 
 * @author (Ahmed Aboo) 
 * @version (Version 1)
 */

 
import java.util.*;

public class Room {
    
    public int room_number;
    public String room_name;
    public int danger_rating;
    public int  capacity;
    public int min_allow_hours;
    
    public Room()
    {
    }
    
    public Room(int rn, String name,int drating,int capacity,int hours)
    {
        this.room_number=rn;
        this.room_name=name;
        this.danger_rating=drating;
        this.min_allow_hours=hours;
        this.capacity=capacity;
    }
    public int get_room_number()
    {
        return this.room_number;
    }
    public int get_room_capacity()
    {
        return this.room_number;
    }
    public String get_room_name()
    {
        return this.room_name;
        
    }
    public  int get_dangr_rating()
    {
        return this.danger_rating;
    }
    public int get_min_hours()
    {
        return this.min_allow_hours;
    }
    
    
    ArrayList<Pass> pass_list =new ArrayList<Pass>();
    public String enter(Pass p1)
    {
        this.pass_list.add(p1);
        return "Successfully Entered Room!";
    }
   
    public String leave(Pass p1)
    {
       int pos=pass_list.indexOf(p1);
       this.pass_list.remove(pos);
       return "Successfully Left Room!";
        
    }
    public ArrayList Get_PassList()
    {
        return this.pass_list;
    }
    
    public Pass Get_Pass(int Pass_id)
    {
       Pass filtered=new Pass(0,"",0,0);
         for (int i = 0; i < pass_list.size(); i++) {
             if (Pass_id==pass_list.get(i).pass_id) 
             {
                 filtered.pass_id=pass_list.get(i).pass_id;
                 filtered.protection_rating=pass_list.get(i).protection_rating;
                 filtered.hours_left=pass_list.get(i).hours_left;
                 filtered.allowable_hours=pass_list.get(i).allowable_hours;
                 filtered.staff_name=pass_list.get(i).staff_name;
                 filtered.moves_count=pass_list.get(i).moves_count;
                 
                 
                 
             }
         }
     return filtered;
    }
   public String check_capacity()
   {
      if (pass_list.size()<this.capacity)
          return "Has Capacity!";
      else
          return "Room Full!";
   }
   public boolean is_pass_present(Pass p)
   {    
        
        boolean val=false;
         for (int i = 0; i < pass_list.size(); i++) 
         {
             if (p.pass_id==pass_list.get(i).pass_id) 
             {
                 val=true;
                 break;
                 
             }
             
         }
         return val;
         
           
   }
   public String toString()
   {
      String s="\n\t\t............Room  Information............\t\t\n";
      s=s+ "RoomNumner..."+this.room_number;
      s=s+"\nRoom Name..."+this.room_name;
      s=s+"\nDanger Rating..."+this.danger_rating;
      s=s+"\nMinimum Allow Hours..."+this.min_allow_hours;
      s=s+"\nTotal Capacity..."+this.capacity;
      s=s+"\n\t\t************************************************************************************\n\t\t";
      
      
      s=s+"\n\n\n\t\t............Pass  Information............\t\t";
      for (int i=0;i<this.pass_list.size();i++)
      {
       s=s+"\n\t\t************************************************************************************\n\t\t";
       s=s+"\nPass Number..."+pass_list.get(i).pass_id;
       s=s+"\nStaff Name..."+pass_list.get(i).staff_name;
       s=s+"\nHours Allowed..."+pass_list.get(i).allowable_hours;
       s=s+"\nProtection Rating..."+pass_list.get(i).protection_rating;
       s=s+"\nHours Left..."+pass_list.get(i).hours_left;
       s=s+"\nTotal Moves Made Today..."+pass_list.get(i).moves_count;
       
       }
       s=s+"\n\t\t************************************************************************************\n\t\t";
     return s;
   }
}

