package combinations;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by snyder on 2015-07-06.
 */
public class CombinationsTest {

    @Test
    public void testSize() throws Exception {
        Combinations c = new Combinations();
        assertEquals(c.size(), 0, "No elements are in current collection, size should be 0");
        c.add("");
        assertEquals(c.size(), 1, "one element is in current collection, size should be 1");
    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testContains() throws Exception {

    }

    @Test
    public void testAddAll() throws Exception {

    }

    @Test
    public void testRemoveAll() throws Exception {

    }

    @Test
    public void testClear() throws Exception {

    }
}