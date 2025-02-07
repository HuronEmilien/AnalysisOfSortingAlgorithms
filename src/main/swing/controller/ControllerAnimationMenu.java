package main.swing.controller;

import main.swing.model.*;
import main.swing.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControllerAnimationMenu extends JPanel implements ActionListener {

    private SortingList sl;
    private GUI gui;
    private JMenuBar menuBar;

    public ControllerAnimationMenu(SortingList sl, GUI gui) {
        super();
        this.sl = sl;
        this.gui = gui;
        String[] animations = {"Vbars", "Points", "Pyramid", "Lines", "Table"};
        this.menuBar = new Menu(this, animations, "Animations");
        this.add(this.menuBar);
        this.setBackground(Color.WHITE);
    }

    public void setMenuEnabled(boolean enabled) {
        for (Component component : this.menuBar.getComponents()) {
            component.setEnabled(enabled);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JMenuItem) {
            String item = ((JMenuItem) e.getSource()).getText();
            switch (item) {
                case "Vbars":
                    this.gui.setAnimation(new VBarAnimationView(this.sl));
                    break;
                case "Points":
                    this.gui.setAnimation(new PointAnimationView(this.sl));
                    break;
                case "Pyramid":
                    this.gui.setAnimation(new PyramidAnimationView(this.sl));
                    break;
                case "Lines":
                    this.gui.setAnimation(new LineAnimationView(this.sl));
                    break;
                case "Table":
                    System.out.println("Soon...");
                    break;
                default:
                    throw new RuntimeException("Invalid item : " + item);
            }
        }
    }

}
