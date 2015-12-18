package stackpanel;

import java.awt.*;

/**
 * Created by snyder on 2015-09-30.
 */
    public class VerticalLayout implements LayoutManager {
        private final Dimension minimumSize = new Dimension();

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            Dimension dimension = new Dimension(getTotalPaddingWidth(parent),parent.getWidth() + getTotalPaddingHeight(parent));
            minimumSize.height = dimension.height;
            for(Component c :parent.getComponents()){
                if(!c.isVisible()){
                    continue;
                }

                Dimension preferredSize = c.getPreferredSize();
                dimension.height += preferredSize.getHeight();
                if(preferredSize.width > dimension.width){
                    dimension.width = preferredSize.width;
                }
            }
            minimumSize.width = dimension.width;
            return dimension;
        }

        private int getTotalPaddingWidth(Container container) {
            Insets padding = container.getInsets();
            return padding.left + padding.right;
        }
        private int getTotalPaddingHeight(Container container){
            Insets padding = container.getInsets();
            return padding.top + padding.bottom;
        }
        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return minimumSize;
        }

        @Override
        public void layoutContainer(Container parent) {
            Insets padding = parent.getInsets();
            int y = padding.top;
            for(Component c : parent.getComponents()){
                if(c.isVisible()) continue;;

                c.setBounds(padding.left, y, parent.getWidth(), c.getPreferredSize().height);
                y += c.getHeight();
            }
        }
    }
