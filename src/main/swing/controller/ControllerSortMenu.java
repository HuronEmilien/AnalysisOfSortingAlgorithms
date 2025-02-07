package main.swing.controller;

import main.swing.model.*;
import main.swing.model.sort.*;
import main.swing.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControllerSortMenu extends JPanel implements ActionListener  {

    private SortingList sl;
    private GUI gui;
    private JMenuBar menuBar;

    public ControllerSortMenu(SortingList sl, GUI gui) {
        super();
        this.sl = sl;
        this.gui = gui;
        String[] sorts = {"Bubble", "Cocktail", "Gnome", "Heap", "Insert", "Merge", "Quick", "Radix", "Selection", "Shell","Tim"};
        this.menuBar = new Menu(this, sorts, "Sorts");
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
            gui.refresh();
            switch(item) {
                case "Bubble":
                    this.sl.reload(new BubbleSort(), item);
                    break;
                case "Cocktail":
                    this.sl.reload(new CocktailShakerSort(), item);
                    break;
                case "Gnome":
                    this.sl.reload(new GnomeSort(), item);
                    break;
                case "Heap":
                    this.sl.reload(new HeapSort(), item);
                    break;
                case "Insert":
                    this.sl.reload(new InsertionSort(), item);
                    break;
                case "Merge":
                    this.sl.reload(new MergeSort(), item);
                    break;
                case "Quick":
                    this.sl.reload(new QuickSort(), item);
                    break;
                case "Radix":
                    this.sl.reload(new RadixSort(), item);
                    break;
                case "Selection":
                    this.sl.reload(new SelectionSort(), item);
                    break;
                case "Shell":
                    this.sl.reload(new ShellSort(), item);
                    break;
                case "Tim":
                    this.sl.reload(new TimSort(), item);
                break;
                default:
                    throw new RuntimeException("Invalid item : " + item);
            }
        }
    }

}
