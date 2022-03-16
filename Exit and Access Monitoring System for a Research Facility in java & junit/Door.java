
/**
 * A door provides a one-way connection between two rooms. It
 * has a Door number and information about both the "from" and
 * the "to" room
 * 
 * @author (Ahmed Aboo) 
 * @version (Version 1)
 */
public class Door {
    public Room room_from;
    public Room room_to;
    public int door_id;
    
    
    public Door (int did)
    {  
        this.door_id=did;
    }
            
   
    
    public boolean is_move_allow(Pass p,Room src,Room dest)
    {
        room_from=src;
        room_to=dest;
        String room_capacity=room_to.check_capacity();
        boolean pass_Check=room_from.is_pass_present(p);
        
        if (p.protection_rating<room_to.danger_rating)
            return false;
        else if (p.hours_left<room_to.min_allow_hours)
        {
            return false;
        }
        else if (p.moves_count>5)
        {
            return false;
        }

        else if(room_capacity=="Room Full")
        {
            return false;
        }
        else if(!pass_Check)
         {
             return false;
         }
        else
        {
            return true;
        }
        
}
    public String  try_move(Pass p,Room src,Room dest)
    {
        
        boolean move=this.is_move_allow(p,src,dest);
        if(move)
        {
            room_from.pass_list.remove(p);
            p.deduct_hours(this.room_to.min_allow_hours);
            p.protection_rating=p.protection_rating+room_to.danger_rating;
            p.moves_increment();
            this.room_to.pass_list.add(p);
            String Pass_info=p.toString();
            String room_name=this.room_to.room_name;
            return "You Have Moved to..."+room_name+"\nYour Pass is updated with required info!\n\n"+Pass_info;
            
            
        }
        else{
            return "Cannot Move to Room\nReview Your Pass"+p.toString();
            }
        
    }
    public String toString()
    {
        int room_to_number=this.room_to.room_number;
        String room_to_name=this.room_to.room_name;
        int room_from_number=this.room_from.room_number;
        String room_from_name=this.room_from.room_name;
        
        String s="Source Room Number...="+room_from_number;
        s=s+"\nSource Room Name...="+room_from_name;
        s=s+"\nDestination Room Number"+room_to_number;
        s=s+"\nDestination Room Name"+room_to_name;
        return s;
        
    }
}