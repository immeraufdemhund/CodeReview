package locationBranching;

/**
 * Created by snyder on 2015-07-21.
 */
public class Location {
    private int count;
    private String locationName;

    public Location(String name, int count) {
        this.count = count;
        this.locationName = name;
    }

    public String toString() {
        return locationName + " (" + count + ")";
    }

    public String getLocation() {
        return locationName;
    }

    public void increaseCount() {
        count++;
    }
}
