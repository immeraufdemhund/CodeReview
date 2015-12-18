package locationBranching;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;

/**
 * Created by snyder on 2015-07-21.
 */
public class Test extends JPanel {
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JFrame frame = new JFrame("List Example");
                frame.setSize(450, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new Test());
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Test() {
        setLayout(new BorderLayout());
        initialize();
    }

    private class asdf implements ListDataListener{

        @Override
        public void intervalAdded(ListDataEvent e) {
            System.out.println("added:" + e);
        }

        @Override
        public void intervalRemoved(ListDataEvent e) {
            System.out.println("removed:" + e);

        }

        @Override
        public void contentsChanged(ListDataEvent e) {
            System.out.println("changed:" + e);
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        JPanel listsPanel = new JPanel(new BorderLayout());

        DefaultListModel<Branch> branches = initializeBranchesPanel(listsPanel);
        DefaultListModel<Location> location = initializeLocationPanel(listsPanel);
        JButton btnDelete = initialzeDeleteButtonPanel();

        branches.addListDataListener(new asdf());
        add(listsPanel, BorderLayout.NORTH);
        add(btnDelete, BorderLayout.SOUTH);

        putDataIntoBranches(branches);

/*
            if (!locationList.isSelectionEmpty()) {
                String selectedLocation = locationList.getSelectedValue().getLocation();
                location.removeElementAt(locationList.getSelectedIndex());

                for (int k = branch.size() - 1; k >= 0; k--) {
                    if (branch.get(k).getLocation().toLowerCase().equals(selectedLocation)) {

                        System.out.println(branch.get(k));
                        branch.removeElement(branch.get(k));
                    }
                }

            } else if (!branchList.isSelectionEmpty()) {
                branch.removeElementAt(branchList.getSelectedIndex());

            } else {
                JOptionPane.showMessageDialog(frame, "Select one of the list first");
            }
                    initializeLocationList(locationList);

        DefaultListModel<Branch> branch = getBranchDefaultListModel();

        JList<Branch> branchList = initializeBranchList(branch);

        locationCount = new ArrayList<>();


        for (int i=0;i<branch.size();i++) {
            locationCount.add(branch.get(i).getLocation());
        }

        // Group similar strings
        Map<String, Long> counts = locationCount.stream()
                .collect(Collectors.groupingBy(e -> e.toString().toLowerCase(),
                        Collectors.counting()));

        total = 0L;

        for (Long a : counts.values()) {
            total += a;
        }

        showLocation = new HashMap<>();


        for ( Map.Entry<String, Long> entry : counts.entrySet()) {
            String key = entry.getKey();
            Long locCount = entry.getValue();
            Double percent = (locCount/Double.valueOf(total))*100;
            showLocation.put(new Location(key,locCount), percent);
        }



        for (Location a : showLocation.keySet()) {
            location.addElement(a);
        }
*/
    }

    private JButton initialzeDeleteButtonPanel() {
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(this::deleteSomething);
        return btnDelete;
    }

    private void putDataIntoBranches(DefaultListModel<Branch> branches) {
        branches.addElement(new Branch("London", "Branch 1"));
        branches.addElement(new Branch("London", "Branch 2"));
        branches.addElement(new Branch("Manchester", "Branch 3"));
        branches.addElement(new Branch("London", "Branch 4"));
        branches.addElement(new Branch("Manchester", "Branch 5"));
    }

    private void deleteSomething(ActionEvent actionEvent) {
        System.out.println(actionEvent);
    }

    private DefaultListModel<Branch> initializeBranchesPanel(JPanel listPanel) {
        DefaultListModel<Branch> branches = new DefaultListModel<>();
        JList<Branch> locationList = new JList<>(branches);
        locationList.addListSelectionListener(this::selectBranch);
        JScrollPane pane = new JScrollPane(locationList);
        listPanel.add(pane, BorderLayout.EAST);

        return branches;
    }

    private void selectBranch(ListSelectionEvent listSelectionEvent) {
        System.out.println(listSelectionEvent);
    }

    private DefaultListModel<Location> initializeLocationPanel(JPanel listPanel) {
        DefaultListModel<Location> location = new DefaultListModel<>();
        JList<Location> locationList = new JList<>(location);
        locationList.addListSelectionListener(this::selectBranch);
        JScrollPane pane = new JScrollPane(locationList);
        listPanel.add(pane, BorderLayout.WEST);
        return location;
    }

}
