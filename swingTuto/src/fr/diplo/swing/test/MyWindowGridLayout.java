package fr.diplo.swing.test;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MyWindowGridLayout extends JFrame {

    public MyWindowGridLayout() {
        super("My first application");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        /**
         * GridLayout positionne les éléments en fonction d'un nombre de lignes et colonnes
         * Il ignore la taille de chaque élément (il remplit chaque "case" par l'élément)
         * il gère aussi les marges hgap et vgap mais seulement pour chaque élément
         */
        contentPane.setLayout(new GridLayout(2,2,10,10));
        JButton btnPushme = new JButton("Push me");
        contentPane.add(btnPushme);

        JButton btnClickMe = new JButton("Click me!!!!!!");
        contentPane.add(btnClickMe);

        JCheckBox chkCheckMe = new JCheckBox("Check me!");
        contentPane.add(chkCheckMe);

        JTextField txtEdit = new JTextField("Edit me!");
        contentPane.add(txtEdit);
    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyWindowGridLayout myWindow = new MyWindowGridLayout();
        myWindow.setVisible(true);
    }

}
