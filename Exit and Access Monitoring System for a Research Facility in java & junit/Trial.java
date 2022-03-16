
/**
 * Write a description of class Trial here.
 *
 * @author (Ahmed Aboo)
 * @version (Version 1)
 */
public class Trial
{
    public int Trial_Number;
    public String Category;
    public boolean Completed;
    public int Sample_Size;
    public int Positive_Results;

    /**
     * Constructor for objects of class Trial
     */
    public Trial(int Trial_Number, String category, int Completed, int Sample_Size, int Positive_Results)
    {
        this.Trial_Number=1;
        this.Category=Category;
        this.Completed=false;
        this.Sample_Size=100;
        this.Positive_Results=0;   
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int GetsampleSize ()
    {
      return this.Sample_Size;  
        
    }
}
