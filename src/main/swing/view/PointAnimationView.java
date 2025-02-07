package main.swing.view;

import main.swing.model.*;

import java.awt.*;

/**
 *
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class PointAnimationView extends AnimationStrategy {

    public PointAnimationView(SortingList sl) {
        super(sl);
    }

    @Override
    protected void drawGeometricShape(Graphics g, int i) {
        int size = this.sl.getSize();
        int width = getWidth();
        int height = getHeight();
        int pointSize = 5;
        int x = i * (width - 2) / size + (width - 2) / (2 * size) - pointSize / 2;
        int y = height - (int) ((this.sl.getGeneratorData()[i] / (double) size) * (height - 2)) - pointSize / 2;
        g.fillOval(x, y, pointSize, pointSize);
        g.setColor(Color.BLACK);
    }

}
