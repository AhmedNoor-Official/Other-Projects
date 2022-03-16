
/**
 * The test class PassTest.
 *
 * @author  (Ahmed Aboo)
 * @version (Version 1)
 */
public class PassTester
{
    /**
     * Default constructor for test class PassTest
     */
    public PassTester()
    {
        
    }
    
     
    
    
    public static void main()
    {
        Pass p1=new Pass(10,"Ahmed",3,13);
        Pass p2=new Pass(11,"Ahmed2",5,12);
    
        String s=p1.deduct_hours(1);
        System.out.println(s);
        
        p1.toString();
        String s2=p1.deduct_hours(1);
        System.out.println(s2);
        p2.toString();
        
    }
    

    
}
