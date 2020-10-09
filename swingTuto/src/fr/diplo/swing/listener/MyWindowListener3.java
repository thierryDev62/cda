package fr.diplo.swing.listener;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyWindowListener3 extends JFrame {

    private JButton btnPushme = new JButton("Push me");
    private JButton btnClickMe = new JButton("Click me!!!!!!");

    public MyWindowListener3() {
        super("My first application");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout());

        /*btnPushme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPushListener(e);
            }
        });*/
        btnPushme.addActionListener((e) -> btnPushListener(e)); // lambda
        contentPane.add(btnPushme);

        btnClickMe.addActionListener((e) -> System.out.println("btnClickMe clicked"));
        contentPane.add(btnClickMe);

        JCheckBox chkCheckMe = new JCheckBox("Check me!");
        contentPane.add(chkCheckMe);

        JTextField txtEdit = new JTextField("Edit me!");
        txtEdit.setPreferredSize(new Dimension(120,30));
        contentPane.add(txtEdit);
    }

    private void btnPushListener(ActionEvent e) {
        btnClickMe.setText("ouille");
        System.out.println("btnPushMe clicked");
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyWindowListener3 myWindow = new MyWindowListener3();
        myWindow.setVisible(true);
    }

}
