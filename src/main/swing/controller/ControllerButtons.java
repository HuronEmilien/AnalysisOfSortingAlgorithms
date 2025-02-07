package main.swing.controller;

import main.swing.model.*;
import main.swing.view.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * 
 * @author Florian Pépin
 * @version 1.0
 */
public class ControllerButtons extends JPanel implements ActionListener {

    public final static String ICON_PATH = "/main/swing/resources/icon/";
    private SortingList sortingList;
    private ControllerSortMenu sortMenu;
    private ControllerAnimationMenu animationMenu;
    private GUI gui;
    private Thread sortingThread;
    private JButton sortButton;
    private JButton reloadButton;

    public ControllerButtons(SortingList sortingList, ControllerSortMenu sortMenu, ControllerAnimationMenu animationMenu) {
        super();
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        this.setBackground(Color.WHITE);
        this.sortingList = sortingList;
        this.sortMenu = sortMenu;
        this.animationMenu = animationMenu;
        this.gui = gui;
        this.sortButton = createButton("SORT", this.createIcon(ICON_PATH+"run.png"));
        this.reloadButton = createButton("RELOAD", this.createIcon(ICON_PATH+"reload.png"));
        this.reloadButton.setEnabled(false);
        this.add(this.sortButton);
        this.add(this.reloadButton);
    }

    public JButton getSortButton() {
        return this.sortButton;
    }

    public JButton getReloadButton() {
        return this.reloadButton;
    }

    private ImageIcon createIcon(String path) {
        try {
            return new ImageIcon(getClass().getResource(path));
        } catch (Exception ex) {
            throw new RuntimeException("Invalid Path : " + ex.getMessage());
        }
    }

    private JButton createButton(String text, ImageIcon icon) {
        JButton button = new JButton(icon);
        button.setActionCommand(text);
        button.setPreferredSize(new Dimension(45, 45));
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(button.getBackground());
        button.addActionListener(this);
        button.addMouseListener(new MouseOverEvent(button));
        button.setBackground(Color.WHITE);
        return button;
    }

    public void setMenusEnabled(boolean enabled) {
        this.sortMenu.setMenuEnabled(enabled);
        this.animationMenu.setMenuEnabled(enabled);
    }

    private void run() {
        this.sortingThread = new Thread(() -> {
            try {
                this.setMenusEnabled(false);
                this.sortButton.setEnabled(false);
                this.reloadButton.setEnabled(true);
                this.sortingList.sort();
                this.setMenusEnabled(true);
            } catch (Exception ex) {
                this.setMenusEnabled(true);
            }
        });
        this.sortingThread.start();
    }

    @Override
    public synchronized void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            String command = e.getActionCommand();
            switch(command) {
                case "SORT":
                    this.reloadButton.setEnabled(true);
                    this.run();
                    break;
                case "RELOAD":
                    this.reloadButton.setEnabled(false);
                    if (this.sortingThread != null) this.sortingThread.interrupt();
                    this.sortingList.reload();
                    this.sortButton.setEnabled(true);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Action.");
            }
        }
    }

}
