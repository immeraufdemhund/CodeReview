package stackpanel;

import javax.swing.JPanel;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.PanelUI;
import java.awt.*;

/**
 * Created by snyder on 2015-09-30.
 */
public class VerticalPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public VerticalPanel(int nrOfComps) {
        //LayoutManager layout = getVerticalLayout(nrOfComps);
        setLayout(new VerticalLayout());
    }

    @Override
    public Component add(Component comp) {
        return super.add(comp);
        //return add(comp, getComponentCount());
    }

    @Override
    public Component add(Component comp, int index) {
        return super.add(comp, index);/*
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Allocate extra width to the buttons
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = index;
        add(comp, gbc);
        return comp;*/
    }

    private LayoutManager getVerticalLayout(int nrOfComps) {
        GridBagLayout layout = new GridBagLayout();

        double[] rowWeights = new double[nrOfComps];
        rowWeights[nrOfComps - 1] = Double.MIN_VALUE;
        layout.rowWeights = rowWeights;
        return layout;
    }

    private String __func__(){
        return new Exception().getStackTrace()[1].getMethodName();
    }
}
