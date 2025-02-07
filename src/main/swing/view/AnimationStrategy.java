package main.swing.view;

import main.swing.utils.*;
import main.swing.model.*;

import java.awt.*;
import javax.swing.*;

/**
 *
 *
 * @author Florian Pépin
 * @version 1.0
 */
public abstract class AnimationStrategy extends JPanel implements ModelListener {

    protected static int SLEEP = 5;
    protected SortingList sl;
    protected String eventType;
    protected int count;

    public AnimationStrategy(SortingList sl) {
        this.sl = sl;
        this.sl.addModelListener(this);
        this.eventType = "step";
        this.count = 0;
        setBackground(Color.BLACK);
    }

    public int getSleep() {
        return AnimationStrategy.SLEEP;
    }

    public void setSleep(int s) {
        if (AnimationStrategy.SLEEP < 0) {
            throw new IllegalArgumentException("Sleep value cannot be negative.");
        }
        AnimationStrategy.SLEEP = s;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(eventType.equals("step")) {
            this.drawSortStep(g);
        } else if(eventType.equals("end")) {
            this.drawSortEnd(g);
        }
    }

    public void drawSortStep(Graphics g) {
        for (int i = 0; i < this.sl.getSize(); i++) {
            if (this.sl.getCurrent1() == i) {
                g.setColor(Color.GREEN);
            } else if (this.sl.getCurrent2() == i) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.WHITE);
            }
            this.drawGeometricShape(g, i);
        }
    }

    public void drawSortEnd(Graphics g) {
        for (int i=0; i < this.sl.getSize(); i++) {
            if(this.count >= i) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.WHITE);
            }
            this.drawGeometricShape(g, i);
        }
    }

    abstract void drawGeometricShape(Graphics g, int i);

    protected void sleep(long multiplier) {
        try {
            Thread.sleep(AnimationStrategy.SLEEP * multiplier);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted Exception : "+e.getMessage());
        }
    }

    @Override
    public void updatedModel(Object source, String eventType) {
        this.eventType = eventType;
        if(this.eventType.equals("end")) {
            while (this.count < this.sl.getSize()) {
                this.count++;
                SwingUtilities.invokeLater(this::repaint);
                this.sleep(6L);
            }
            this.eventType = "step";
            this.count = 0;
        } else {
            this.sleep(2L);
            SwingUtilities.invokeLater(this::repaint);
        }
    }

}
