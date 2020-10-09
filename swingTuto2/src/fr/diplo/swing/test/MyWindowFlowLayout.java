package fr.diplo.swing.test;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MyWindowFlowLayout extends JFrame {

    public MyWindowFlowLayout() {
        super("My first application");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        
        JButton btnPushme = new JButton("Push me");
        contentPane.add(btnPushme);

        JButton btnClickMe = new JButton("Click me!!!!!!");
        contentPane.add(btnClickMe);

        JCheckBox chkCheckMe = new JCheckBox("Check me!");
        contentPane.add(chkCheckMe);

        JTextField txtEdit = new JTextField("Edit me!");
        txtEdit.setPreferredSize(new Dimension(120,30));
        contentPane.add(txtEdit);
    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyWindowFlowLayout myWindow = new MyWindowFlowLayout();
        myWindow.setVisible(true);
    }

}
