package locationBranching;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * Created by snyder on 2015-07-22.
 */
public class BranchData implements ListDataListener {
    private DefaultListModel<Branch> branches = new DefaultListModel<>();
    private DefaultListModel<Location> locations = new DefaultListModel<>();

    public BranchData() {
        branches.addListDataListener(this);
    }

    public void addBranch(Branch branch) {
        branches.addElement(branch);
    }

    public DefaultListModel<Location> getLocations() {
        return locations;
    }

    @Override
    public void intervalAdded(ListDataEvent e) {
        //debating about just using branches, or using the getSource(),
        //for now I'll keep this modular.
        Branch branchAdded = ((DefaultListModel<Branch>) e.getSource())
                .elementAt(e.getIndex0());

        if (updatedExistingLocationCount(branchAdded)) return;

        locations.addElement(new Location(branchAdded.getLocation(), 1));
    }

    private boolean updatedExistingLocationCount(Branch branchAdded) {
        for (int i = 0; i < locations.size(); i++) {
            Location location = locations.get(i);
            if(location.getLocation()==branchAdded.getLocation()){
                location.increaseCount();
                return true;
            }
        }
        return false;
    }

    @Override
    public void intervalRemoved(ListDataEvent e) {
    }

    @Override
    public void contentsChanged(ListDataEvent e) {
    }
}
