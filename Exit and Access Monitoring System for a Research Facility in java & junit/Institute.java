import java.util.*;

/**
 *
 * @author A.A.Marczyk 
 * @version 09/11/20
 **/
public class Institute implements CREAM
{
    private ArrayList<Pass> allPasses = new ArrayList<Pass>();
    private ArrayList<Room> allRooms = new ArrayList<Room>();
    private ArrayList<Door> allDoors = new ArrayList<Door>();

    /** constructor
     */
    public Institute() 
    {
        this.loadPasses();
        this.loadRooms();
        this.setUpDoors();
        
    }
    
    /**
     * Returns all of the details of all rooms including the passes
     * currently in each room, or "No passes"
     * @return all of the details of all rooms including location 
     * of all passes currently in each room, or "No passes" 
     */
    public String toString()
    {
       
        String s="";
        
        for (int i=0;i<allRooms.size();i++)
        {
            
            ArrayList<Pass> al=allRooms.get(i).pass_list;
            if (al.size()==0){
                
               s="No Passes In Room";
               return s;
            }
            else
            {
            for (Pass item:al)
                    {
                        s=s+item.toString();
                        
                    }
             }
        }
        return s;
    }

    /**Returns a String representation of all the passes in all rooms
     * @return a String representation of all passes in all rooms, room code
     * and name should be included at the start of the list
     **/
    public String getAllPassesInAllRooms()
    {
        
        String s="";
        
        for (int i=0;i<allRooms.size();i++)
        {
            
          s=s+allRooms.get(i).toString();
        
        
        }
        
       return s;
       
        
    } 
 
    
    /**Returns the name of the room which contains the specified pass or null
     * @param ps - the specified pass
     * @return the number of the Room which contains the pass, or -1
     **/
    public int findPass(int ps)
    {
        for(Room rm:allRooms)
        {
           for(int i=-0;i<rm.pass_list.size();i++)
           {
               if (ps==rm.pass_list.get(i).pass_id)
               {
                   return rm.room_number;
               }
           }
           
           
            
        }
        return -1;
        
    }
    
    /** Given the name of a room, returns the room code
     * or null if room does not exist
     * @param name of room
     * @return number of room, or -1 if the room does not exist
     */
    public int getRoomNo(String rm)
    {
        for(Room room:allRooms)
        {
           if (room.room_name==rm)
           {
               return room.room_number;
           }
        }
        return -1;
    }
                
    /**Returns a String representation of all the passes in specified room
     * @roomCode the room code
     * @return a String representation of all passes in specified room, or
     * "No such room"
     **/
    public String getAllPassesInRoom(int rmNo)
    {
        for(int i=0;i<allRooms.size();i++)
         {
             if (allRooms.get(i).room_number==rmNo)
             {
                 return allRooms.get(i).toString();
             }
         }
         return "Room Number Not Found!";
        
    } 

    /** Returns a String with all of the details of a Pass
     * @param passNo is the pass number
     * @return all details of the Pass, or "No such Pass"
     */
    public String showPass(int pNo)
    {
        for(int i=0;i<allPasses.size();i++)
         {
             if (allPasses.get(i).pass_id==pNo)
             {
                 return allPasses.get(i).toString();
             }
         }
        return "No such Pass!";
    }
    
     /**Returns true if a Pass is allowed to move using the door, false otherwise
     * A move can be made if:  
     * the protection rating of the pass  >= the danger rating of the destination room
     * AND the destination room is not full
     * AND the pass has hours left >= limit of the destination room
     * AND the pass is currently in the source room
     * AND the pass id is for a pass in the system
     * AND the door number is the number for a door in the system
     * @param psId is the id of the pass requesting the move
     * @param doorNo is the number of the door through which the pass wants to move
     * @return true if the pass is allowed in the move, false otherwise 
     **/
    public boolean canMove(int psId, int doorNo)
    {   
        
        String s= showPass(psId);
        int loc= findPass(psId);
        Room src=new Room();
        Room dest=new Room();
        if(doorNo==0)
        {
             dest=allRooms.get(1);
            
        }
        else if(doorNo==1)
        {
            dest=allRooms.get(0);
        }
        else if(doorNo==2)
        {
            dest=allRooms.get(2);
        }
        else if(doorNo==3)
        {
            dest=allRooms.get(1);
        }
        else if(doorNo==4)
        {
            dest=allRooms.get(1);
        }
        
        else if(doorNo==5)
        {
            dest=allRooms.get(4);
        }
        
        else if(doorNo==6)
        {
            dest=allRooms.get(1);
        }
        else if(doorNo==7)
        {
            dest=allRooms.get(3);
        }
        else if(doorNo==8)
        {
            dest=allRooms.get(3);
        }
        

        
        for(Room rm:allRooms)
        {
            if(loc==rm.room_number)
            {
                src=rm;
            }
        }
        
        
         if (s=="No such Pass!")
            {
               
                return false;
                      
            }    
         boolean found=false;
         for(Door dr:allDoors)   
         {
             
             if(dr.door_id==doorNo)
             {
                 found=true;
                 
             }
             
         }
         
         if (found==false)
         {
             return false;
         }
         
         Pass preq=this.getPass(psId);
         
         for(Door d:allDoors)
         {
             if(d.door_id==doorNo)
             {
                 found=d.is_move_allow(preq,src,dest);
                 if (found==false)
                     return false;
                 
             }
         }
        return true;
         
     }
        
         

    /**Returns the result of a pass requesting to move by Door.
     * A move will be successful if:  
     * the protection rating of the pass  >= the danger rating of the destination room
     * AND the destination room is not full
     * AND the pass has sufficient hours left >= limit of the destination room
     * AND the pass is currently in the source room
     * AND the pass id is for a pass in the system
     * AND the door number is the number for a door in the system
     * If the move can be made, the pass information is removed from the source
     * room, added to the destination room and a suitable message returned.
     * If move cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param psId is the id of the pass requesting the move
     * @param doorNo is the number of the door through which the pass wants to move
     * @return a String giving the result of the request 
     **/
    public String move(int psId, int doorNo )
    {   
        String s="Not moved!";
            Pass preq=this.getPass(psId);
            int loc=findPass(psId);
            Room src=new Room();
            Room dest=new Room();
        if(doorNo==0)
        {
             dest=allRooms.get(1);
            
        }
        else if(doorNo==1)
        {
            dest=allRooms.get(0);
        }
        else if(doorNo==2)
        {
            dest=allRooms.get(2);
        }
        else if(doorNo==3)
        {
            dest=allRooms.get(1);
        }
        else if(doorNo==4)
        {
            dest=allRooms.get(1);
        }
        
        else if(doorNo==5)
        {
            dest=allRooms.get(4);
        }
        
        else if(doorNo==6)
        {
            dest=allRooms.get(1);
        }
        else if(doorNo==7)
        {
            dest=allRooms.get(3);
        }
        else if(doorNo==8)
        {
            dest=allRooms.get(3);
        }
        

        
        for(Room rm:allRooms)
        {
            if(loc==rm.room_number)
            {
                src=rm;
            }
        }
        
            
            
            for(Door d:allDoors)
            {
                if(d.door_id==doorNo)
                {
                    s=d.try_move(preq,src,dest);
                }
            }
        return s;
        
    } 
            
    /** Resets all passes:  moves to 0, available hours left to allowable hours
     */
    public void resetAllPasses()
    {
    for (Pass  p:allPasses)  
       {
           p.reset();
       } 
        
    }

    // These methods are for Task 7 only and not required for the Demonstration 
    // If you choose to implement them, uncomment the following 

    /** Resets one passes: moves to 0, available hours left to allowable hours  
     * @param id of the pass
     */
    public void resetPass(int id)
    {
        for (Pass p:allPasses)
        {
            if(p.pass_id==id)
            {
                p.reset();
            }
            
        }
    }
    
    /** Moves a pass directly back to the Outside without affecting data
     *  and not using existing doors
     */
    public void moveOutside(int id)
    {
       Pass preq=this.getPass(id);
       
       this.move(id,1);
    
    }
   
    /** In an emergency, evacuates all passes directly back to the Outside without 
     * affecting information and not using existing doors
     */
    

    
   
    //***************private methods**************
    private void loadRooms()
    {
    Room r1=new Room(100,"Outside",0,1000,0);
    Room r2=new Room(101,"StaffRoom",1,100,1);
    Room r3=new Room(102,"Lab1",3,10,3);
    Room r4=new Room(103,"Virus_Lab",5,2,4);
    Room r5=new Room(104,"Decontamination",0,1,0);
    
    this.allRooms.add(r1);
    this.allRooms.add(r2);
    this.allRooms.add(r3);
    this.allRooms.add(r4);
    this.allRooms.add(r5);
     
     r1.pass_list=this.allPasses;
        
    }
    
    private void setUpDoors()
    {
    Door d1=new Door(0);
    Door d2=new Door(1);
    Door d3=new Door(2);
    Door d4=new Door(3);
    Door d5=new Door(4);
    Door d6=new Door(5);
    Door d7=new Door(6);
    Door d8=new Door(7);
    Door d9=new Door(8);
    
    this.allDoors.add(d1);
    this.allDoors.add(d2);
    this.allDoors.add(d3);
    this.allDoors.add(d4);
    this.allDoors.add(d5);
    this.allDoors.add(d6);
    this.allDoors.add(d7);
    this.allDoors.add(d8);
    this.allDoors.add(d9);

    }
    
    private void loadPasses()
    {
    Pass p1=new Pass(1000,"Ali",5,10);
    Pass p2=new Pass(1001,"Bert",3,20);
    Pass p3=new Pass(1002,"Ceri",10,20);
    Pass p4=new Pass(1003,"Dana",2,12);
    Pass p5=new Pass(1004,"Eli",3,3);
    Pass p6=new Pass(1005,"Fred",1,5);
    Pass p7=new Pass(1006,"Gani",10,6);
    Pass p8=new Pass(1007,"Hui",7,20);
    Pass p9=new Pass(1008,"Imran",6,24);
    
    this.allPasses.add(p1);
    this.allPasses.add(p2);
    this.allPasses.add(p3);
    this.allPasses.add(p4);
    this.allPasses.add(p5);
    this.allPasses.add(p6);
    this.allPasses.add(p7);
    this.allPasses.add(p8);
    this.allPasses.add(p9);
    
    }
 
    // You may find these methods useful to simplify your code above
    /** Returns the pass with the pass id specified by the parameter
     * @return the pass with the specified name
     **/
    public Pass getPass(int id)
    {
        Pass req=new Pass(0,"",0,0);
        for (Pass p:allPasses)
        {
            if(p.pass_id==id)
            {
                req=p;
            }
            
        }
        return req;
        
    }
    public void evacuateall()
    {
      
       System.out.println("*************** All Passes Evacuated*****************");
        
    }
    /** Returns the room with the name specified by the parameter
     * @param roomNo is the number of the required room
     * @return the room with the specified name
     **/
    private Room getRoom(int roomNo)
    {
        return null;
    }
    
    /** Returns the room with the name specified by the parameter
     * @return the room with the specified name
     **/
    private Door getDoor(int dr)
    {
       
        return null;
    }
}