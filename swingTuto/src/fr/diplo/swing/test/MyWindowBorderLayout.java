package fr.diplo.swing.test;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MyWindowBorderLayout extends JFrame {

    public MyWindowBorderLayout() {
        super("My first application");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        /**
         * BorderLayout divise la zone en 5 espaces :
         * - 4 espaces latéraux (nord, sud, est, ouest) et 1 espace central (centre)
         * Le fait de lui indiquer son positionnement s'appelle une contrainte
         */
        //contentPane.setLayout(new BorderLayout());
        JButton btnPushme = new JButton("Push me");
        contentPane.add(btnPushme, BorderLayout.NORTH);

        JButton btnClickMe = new JButton("Click me!!!!!!");
        btnClickMe.setPreferredSize(new Dimension(200, 0));
        contentPane.add(btnClickMe, BorderLayout.WEST);

        JCheckBox chkCheckMe = new JCheckBox("Check me!");
        contentPane.add(chkCheckMe, BorderLayout.SOUTH);

        JTextArea txtEdit = new JTextArea("Edit me!");
        contentPane.add(txtEdit);
    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyWindowBorderLayout myWindow = new MyWindowBorderLayout();
        myWindow.setVisible(true);
    }

}
