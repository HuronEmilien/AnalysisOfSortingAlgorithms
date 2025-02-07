package main.swing.view;

import main.swing.model.*;

import java.awt.*;

/**
 *
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class PyramidAnimationView extends AnimationStrategy {

    public PyramidAnimationView(SortingList sl) {
        super(sl);
    }

    @Override
    public void drawGeometricShape(Graphics g, int i) {
        int size = this.sl.getSize();
        int width = getWidth();
        int height = getHeight();
        
        int baseHeight = (height - 2) / size;
        int value = this.sl.getGeneratorData()[i];
        int baseWidth = (int) ((value / (double) size) * (width - 2));
        int x1 = (width - baseWidth) / 2;
        int x2 = x1 + baseWidth;
        int y = i * baseHeight;
        g.drawLine(x1, y, x2, y);
    }

}
