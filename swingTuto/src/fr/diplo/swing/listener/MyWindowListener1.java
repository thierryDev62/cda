package fr.diplo.swing.listener;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindowListener1 extends JFrame implements ActionListener {

    private JButton btnPushme = new JButton("Push me");
    private JButton btnClickMe = new JButton("Click me!!!!!!");

    public MyWindowListener1() {
        super("My first application");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout());

        btnPushme.addActionListener(this);
        contentPane.add(btnPushme);

        btnClickMe.addActionListener(this);
        contentPane.add(btnClickMe);

        JCheckBox chkCheckMe = new JCheckBox("Check me!");
        contentPane.add(chkCheckMe);

        JTextField txtEdit = new JTextField("Edit me!");
        txtEdit.setPreferredSize(new Dimension(120,30));
        contentPane.add(txtEdit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnPushme) {
            System.out.println("Bouton push me cliqué !");
        } else {
            System.out.println("Autre bouton cliqué");
        }
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyWindowListener1 myWindow = new MyWindowListener1();
        myWindow.setVisible(true);
    }

}
