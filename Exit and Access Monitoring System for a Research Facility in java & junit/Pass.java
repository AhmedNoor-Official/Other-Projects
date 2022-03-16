
/**
 * A Pass has an id number, name, a protection rating and number of hours.
 * 
 * @author (Ahmed Aboo) 
 * @version (Version 1)
 */
public class Pass 
{
    
   
    public int pass_id;
    public String staff_name;
    public int allowable_hours;
    public int protection_rating;
    public int hours_left;
    public int moves_count;
    
    public Pass(int id,String name,int prating,int hours)
    {
        this.pass_id=id;
        this.staff_name=name;
        this.protection_rating=prating;
        this.allowable_hours=hours;
        this.moves_count=0;
        this.hours_left=this.allowable_hours;
        
        
    }
    
   
    public int get_id()
    {
        return this.pass_id;
        
    }
    
    public int get_rating()
    {
       return  this.protection_rating;
       
    }
    public int get_allowable_hours()
    {
        return this.allowable_hours;
       
    }
    
    public int get_moves_count()
    {
        return this.moves_count;
    }
    
    public Boolean  moves_increment()
    {
        if (this.moves_count<5)
        {
           this.moves_count++;
           return true;
        
        }
        else{
            return false;
        }
        }
    public String deduct_hours(int hours)
    {
       if(this.hours_left>hours)
       {
       this.hours_left=this.hours_left-hours;
       return hours+"HR/HRS Deducted....\n Now you have..."+this.hours_left+"Remainig Hours";
       }
       else{
          return "Not enough hours to move into room!";
       }
    }
    public void reset()
    {
        this.hours_left=this.allowable_hours;
        this.moves_count=0;
    }
    
    public String toString()
    {
        return "Pass_ID..."+this.pass_id+"\nStaff Name..."+this.staff_name+"\nAllowable Hours..."+this.allowable_hours+"\nProtection Rating..."+this.protection_rating+"\nHours_Left..."+this.hours_left+"\nMoves Made..."+this.moves_count;
 
        
    }
     
   
    
    
}

