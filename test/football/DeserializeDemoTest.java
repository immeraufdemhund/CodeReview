package football;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by snyder on 2015-09-24.
 */
public class DeserializeDemoTest {

    @Test
    public void testSerialization() throws Exception {
        SerializeDemo serializer = new SerializeDemo();
        serializer.Serialize(1);

        DeserializeDemo deserializer = new DeserializeDemo();
        deserializer.Deserialize(1);
    }

    @Test
    public void correctTestForSerialization() throws Exception{
        ClubInfo club = new ClubInfo();
        club.division = "division";
        club.SSN = 1234;
        club.stadium = "stadium";
        club.stadiumCapacity = 2;
        club.teamName = "teamName";
        SerializeDemo serializer = new SerializeDemo();
        serializer.Serialize(club);

        DeserializeDemo deserializer = new DeserializeDemo();
        ClubInfo deserializedClub = deserializer.Deserialize();

        assertEquals(deserializedClub.division, club.division);
        assertEquals(deserializedClub.SSN, club.SSN);
        assertEquals(deserializedClub.stadium, club.stadium);
        assertEquals(deserializedClub.stadiumCapacity, club.stadiumCapacity);
        assertEquals(deserializedClub.teamName, club.teamName);
    }
}