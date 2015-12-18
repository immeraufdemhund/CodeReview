package football;

/**
 * Created by snyder on 2015-09-24.
 */
import java.io.*;

public class SerializeDemo
{
    public void Serialize(int clubChoice)
    {
        ClubInfo club = new ClubInfo();
        ClubInfo club2 = new ClubInfo();
        club.teamName = "Arsenal";
        club.stadium = "Emirates";
        club.division = "Premier League";
        club.SSN = 11122333;
        club.stadiumCapacity = 60000;
        club2.teamName = "Aston Villa";

        try
        {
            FileOutputStream fileOut = new FileOutputStream("C:/tmp/club.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            //   if (clubChoice == 1){
            out.writeObject(club);
            out.writeObject(club2);
            // out.close();
            // fileOut.close();
            //  }
            //   else
            //   if (clubChoice == 2){
            //   out.writeObject(club2);
            //out2.close();
            //fileout2.close();
            //   }
            System.out.printf("Serialized data is saved in C:/tmp/club.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }

    public void Serialize(ClubInfo club) {
        try (
                FileOutputStream fileOut = new FileOutputStream("C:/temp/club.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut)
        )
        {
            out.writeObject(club);
            System.out.printf("Serialized data is saved in C:/tmp/club.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
}
