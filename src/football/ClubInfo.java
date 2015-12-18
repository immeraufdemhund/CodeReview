package football;

/**
 * Created by snyder on 2015-09-24.
 */
public class ClubInfo implements java.io.Serializable{
    public String teamName;
    public String stadium;
    public String division;
    public transient int SSN;
    public int stadiumCapacity;
}