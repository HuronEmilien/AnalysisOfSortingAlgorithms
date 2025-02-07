package main.swing.view;

import main.swing.model.*;

import java.awt.*;

/**
 *
 *
 * @author Tom David
 * @version 1.0
 */
public class LineAnimationView extends AnimationStrategy {

    public LineAnimationView(SortingList sl) {
        super(sl);
    }

    @Override
    protected void drawGeometricShape(Graphics g, int i) {
        int size = this.sl.getSize();
        int width = getWidth();
        int height = getHeight();

        int x1 = i * (width) / size + (width) / (2 * size);
        int y1 = height - (int) ((this.sl.getGeneratorData()[i] / (double) size) * (height));

        if (i < size - 1) {
            int x2 = (i + 1) * (width) / size + (width) / (2 * size);
            int y2 = height - (int) ((this.sl.getGeneratorData()[i + 1] / (double) size) * (height));
            g.drawLine(x1, y1, x2, y2);
        }
        g.setColor(Color.BLACK);
    }

}
