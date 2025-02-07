package main.swing.view;

import main.swing.model.*;
import main.swing.controller.*;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class GUI extends JFrame {
    
    private SortingList sl;
    private AnimationStrategy animation;
    
    public GUI(SortingList sl) {
        super("Sorting Algorithms");
        this.sl = sl;
        this.animation = new VBarAnimationView(sl);

        this.setSize(1200, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.refresh();
        this.setVisible(true);
    }

    public void setAnimation(AnimationStrategy a) {
        this.sl.removeModelListener(this.animation);
        this.animation = a;
        this.refresh();
    }

    public void refresh() {
        this.getContentPane().removeAll();
        this.showActionPanel();
        this.showAnimation();
        this.revalidate();
        this.repaint();
    }

    public void showActionPanel() {
        JPanel actionPanel = new JPanel();
        actionPanel.setBackground(Color.WHITE);
        actionPanel.setLayout(new GridLayout(1, 3));
        ControllerSortMenu csm = new ControllerSortMenu(this.sl, this);
        actionPanel.add(csm);
        actionPanel.add(new ControllerStatMenu(this.sl));
        ControllerAnimationMenu cam = new ControllerAnimationMenu(this.sl, this);
        actionPanel.add(cam);
        actionPanel.add(new ControllerSlider(this.animation));
        actionPanel.add(new ControllerButtons(this.sl, csm, cam));
        this.add(actionPanel, BorderLayout.NORTH);
    }

    public void showAnimation() {
        JPanel sortPanel = new JPanel();
        sortPanel.setBackground(Color.BLACK);
        sortPanel.setLayout(new BorderLayout());
        sortPanel.add(new ViewStatistic(this.sl), BorderLayout.NORTH);
        sortPanel.add(this.animation, BorderLayout.CENTER);
        this.add(sortPanel, BorderLayout.CENTER);
    }
    
}
