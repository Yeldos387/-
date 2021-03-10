package com.company;

import javax.swing.*;
import java.awt.*;

public class FirstPage extends JPanel {

    private MainFrame parent;

    private JLabel label;
    private JButton back;

    public FirstPage(MainFrame parent) {

        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        label = new JLabel("ADD STUDENT");
        label.setSize(300,30);
        label.setLocation(100,100);
        add(label);

        back = new JButton("Back");
        back.setSize(300,30);
        back.setLocation(100,150);
        add(back);
    }
}
