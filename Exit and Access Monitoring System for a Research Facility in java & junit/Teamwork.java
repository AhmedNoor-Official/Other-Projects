/**
 * Details of your pair
 * 
 * @author (Ahmed Aboo) 
 * @version (Version 1)
 */
public class Teamwork
{
    private String[] details = new String[7];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team
        // It will help us if the surname of programmer1 comes
        // alphabetically before the surname of programmer2
        details[0] = "Team AZ";  // optional
        details[1] = "Aboo";
        details[2] = "Ahmed";
        details[3] = "19011398";
        details[4] = "Ahmed";
        details[5] = "Zoheb";
        details[6] = "19011874";
    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
