package combinations;

import org.testng.annotations.Test;

import java.util.Collection;

import static org.testng.Assert.*;

/**
 * Created by snyder on 2015-07-06.
 */
public class CombinationFactoryTest {

    @Test
    public void testZeroElementsReturnsEmptyCollection(){
        CombinationFactory factory = new CombinationFactory();
        Collection<String> combinations = factory.CreateCombinations("");
    }

}