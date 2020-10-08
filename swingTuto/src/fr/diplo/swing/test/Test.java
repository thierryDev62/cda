package fr.diplo.swing.test;

import javax.swing.*;

/********************************
 *  Test avec Swing UI Designer *
 ********************************/

public class Test {
    private JPanel pane;
    private JButton pushMeButton;
    private JButton clickMeButton;
    private JCheckBox checkMeCheckBox;
    private JTextField editMeTextField;
    private JScrollBar scrollBar1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setContentPane(new Test().pane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
