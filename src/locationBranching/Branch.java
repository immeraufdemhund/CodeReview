package locationBranching;

/**
 * Created by snyder on 2015-07-21.
 */
public class Branch {
    private String loc;
    private String branch;

    public Branch(String loc, String branch) {
        this.loc = loc;
        this.branch = branch;

    }

    public String toString() {
        return "(" + loc + ") - " + branch;
    }

    public String getLocation() {
        return loc;
    }
}