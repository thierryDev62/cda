package fr.diplo.swing.test;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MyWindow extends JFrame {
    public MyWindow() {
        super("My first application");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JButton("Push me!"));
        contentPane.add(new JButton("Click me!!!!!!"));
        contentPane.add(new JCheckBox("Check me!"));
        contentPane.add(new JTextField("Edit me!"));
    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyWindow myWindow = new MyWindow();
        myWindow.setVisible(true);
    }

}
