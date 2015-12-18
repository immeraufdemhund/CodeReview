package football;

/**
 * Created by snyder on 2015-09-24.
 */
import java.io.*;
public class DeserializeDemo
{
    public void Deserialize(int clubChoice)
    {
        ClubInfo club = null;
        ClubInfo club2 = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("C:/tmp/club.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            //   ObjectInputStream in2 = new ObjectInputStream(fileIn);
            //   if (clubChoice == 1){
            club = (ClubInfo) in.readObject();
            club2 = (ClubInfo) in.readObject();
            // in.close();
            // fileIn.close();
            //  } // end if
            // if (clubChoice == 2){
            // club2 = (ClubInfo) in2.readObject();
            // in2.close();
            // fileIn.close();
            //  } // end if
        }catch(IOException i)
        {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Club class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Saved game loaded...");
        System.out.println("Name: " + club.teamName);
        System.out.println("Stadium: " + club.stadium);
        System.out.println("Division: " + club.division);
        // System.out.println("SSN: " + club.SSN);
        System.out.println("Stadium Capacity: " + club.stadiumCapacity);
        System.out.println("Name : " + club2.teamName);

    }

    public ClubInfo Deserialize() {
        try(
            FileInputStream fileIn = new FileInputStream("C:/temp/club.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn)
        ){
            return (ClubInfo) in.readObject();
        }catch(IOException i)
        {
            i.printStackTrace();
            return null;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Club class not found");
            c.printStackTrace();
            return null;
        }

    }
}
