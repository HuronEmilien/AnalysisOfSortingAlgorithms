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
public class ViewStatistic extends JPanel implements ModelListener {

    private SortingList sl;
    private JLabel stats;

    public ViewStatistic(SortingList sl) {
        super();
        this.sl = sl;
        this.sl.addModelListener(this);
        setBackground(Color.BLACK);
        this.stats = new JLabel(this.sl.getSortName()+" Sort"+" - "+this.sl.getComparisons()+" comparisons, "+this.sl.getArrayAccess()+" array accesses, "+this.sl.getDelay()+" ms delay");
        this.stats.setForeground(Color.WHITE);
        add(this.stats, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.stats.setText(this.sl.getSortName()+" Sort"+" - "+this.sl.getComparisons()+" comparisons, "+this.sl.getArrayAccess()+" array accesses, "+this.sl.getDelay()+" ms delay");
    }

    @Override
    public void updatedModel(Object source, String eventType) {
        SwingUtilities.invokeLater(this::repaint);
    }
}
