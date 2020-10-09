package fr.diplo.swing.listener;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.*;

public class MyWindowListener4 extends JFrame {

    private JButton btnPushme = new JButton("Push me");
    private JButton btnClickMe = new JButton("Click me!!!!!!");

    public MyWindowListener4() {
        super("My first application");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout());

        //btnPushme.addActionListener((e) -> btnPushListener(e));
        btnPushme.addActionListener(this::btnPushListener); // Lambda encore plus simplifié
        contentPane.add(btnPushme);

        btnClickMe.addActionListener((e) -> System.out.println("btnClickMe clicked"));
        btnClickMe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnClickMe.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnClickMe.setForeground(Color.BLACK);
            }
        });
        contentPane.add(btnClickMe);

        JCheckBox chkCheckMe = new JCheckBox("Check me!");
        contentPane.add(chkCheckMe);

        JTextField txtEdit = new JTextField("Edit me!");
        txtEdit.setPreferredSize(new Dimension(120,30));
        contentPane.add(txtEdit);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int clickedButton = JOptionPane.showConfirmDialog(MyWindowListener4.this,
                        "Etes-vous sûr de vouloir quitter ?", "Title", JOptionPane.YES_NO_OPTION);
                if(clickedButton == JOptionPane.YES_OPTION) {
                    //MyWindowListener4.this.dispose(); ou ->
                    dispose();
                }
            }
        });
    }

    private void btnPushListener(ActionEvent e) {
        //btnClickMe.setText("ouille");
        System.out.println("btnPushMe clicked");
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyWindowListener4 myWindow = new MyWindowListener4();
        myWindow.setVisible(true);
    }

}
