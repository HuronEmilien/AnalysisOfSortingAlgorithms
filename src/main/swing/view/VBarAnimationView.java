package main.swing.view;

import main.swing.model.*;

import java.awt.*;

/**
 * 
 * 
 * @author Florian Pépin
 * @version 1.0
 */
public class VBarAnimationView extends AnimationStrategy {
    
    public VBarAnimationView(SortingList sl) {
        super(sl);
    }

    @Override
    protected void drawGeometricShape(Graphics g, int i) {
        int size = this.sl.getSize();
        int width = getWidth();
        int height = getHeight();
        int barWidth = width / size;
        int barHeight = (int) ((this.sl.getGeneratorData()[i] / (double) size) * (height - 2));
        int x = i * barWidth;
        int y = height - barHeight;
        g.fillRect(x, y, barWidth, barHeight);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, barWidth, barHeight);
    }
    
}
