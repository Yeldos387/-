package com.company;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {

    private MainFrame parent;

    private JButton firstPageButton;
    private JButton secondPageButton;
    private JButton exitButton;

    public MainMenu(MainFrame parent) {

        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        firstPageButton = new JButton("Add Student");
        firstPageButton.setSize(300,30);
        firstPageButton.setLocation(100,100);
        add(firstPageButton);

        secondPageButton = new JButton("List Students");
        secondPageButton.setSize(300,30);
        secondPageButton.setLocation(100,150);
                add(secondPageButton);

        exitButton = new JButton("Exit");
        exitButton.setSize(300,30);
        exitButton.setLocation(100,200);
        add(exitButton);
    }
}
