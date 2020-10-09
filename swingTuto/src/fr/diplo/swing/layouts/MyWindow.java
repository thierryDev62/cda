package fr.diplo.swing.layouts;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyWindow extends JFrame {

    public MyWindow() {
        super("My first application");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);

        // Mauvaise façon de faire car positionnement en dur
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(null);
        JButton btnPushme = new JButton("Push me");
        btnPushme.setBounds(200, 20, 160, 30);
        contentPane.add(btnPushme);

        JButton btnClickMe = new JButton("Click me!!!!!!");
        btnClickMe.setBounds(200, 70,160,30);
        contentPane.add(btnClickMe);

        JCheckBox chkCheckMe = new JCheckBox("Check me!");
        chkCheckMe.setBounds(200, 120, 160,30);
        contentPane.add(chkCheckMe);

        JTextField txtEdit = new JTextField("Edit me!");
        txtEdit.setBounds(200, 170, 160,30);
        contentPane.add(txtEdit);
    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyWindow myWindow = new MyWindow();
        myWindow.setVisible(true);
    }

}
