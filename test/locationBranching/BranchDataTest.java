package locationBranching;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by snyder on 2015-07-22.
 */
    public class BranchDataTest {
        private BranchData data;
        @BeforeMethod
        public void setup(){
            data = new BranchData();
        }

        @Test
        public void testWhenNewBranchIsAddedNewLocationIsAdded(){
            Branch branch = new Branch("Location", "Branch");
            data.addBranch(branch);

            assertEquals(data.getLocations().size(), 1);
            Location location = data.getLocations().get(0);

            assertEquals(location.toString(), "Location (1)");
        }

        @Test
        public void testWhenMultipleBranchesExistLocationCountIsIncreased(){
            data.addBranch(new Branch("Location", "Branch1"));
            data.addBranch(new Branch("Location", "Branch2"));

            assertEquals(data.getLocations().size(), 1);
            Location location = data.getLocations().get(0);

            assertEquals(location.toString(), "Location (2)");
        }

    }