package main.swing.controller;

import main.swing.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ControllerStatMenu extends JPanel implements ActionListener {

    private SortingList sortingList;
    private URI uri;

    public ControllerStatMenu(SortingList sortingList) {
        super();
        this.sortingList = sortingList;
        String[] stats = {"global", "generate"};
        this.add(new Menu(this, stats, "Statistics"));
        this.setBackground(Color.WHITE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JMenuItem) {
            String item = ((JMenuItem) e.getSource()).getText();
            if ("global".equals(item)) {
                try {
                    WebServer web = new WebServer("http://localhost:8080/web/view/index.html");
                    this.uri = new URI(web.getURL());
                    Desktop.getDesktop().browse(this.uri);
                } catch (BindException bind) {
                    try {
                        Desktop.getDesktop().browse(this.uri);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } catch (IOException | URISyntaxException ex) {
                    throw new RuntimeException("Failed to open the URL: " + ex.getMessage(), ex);
                }
            } else if ("generate".equals(item)) {
                System.out.println("Soon...");
            } else {
                throw new RuntimeException("Invalid item: " + item);
            }
        }
    }

}
