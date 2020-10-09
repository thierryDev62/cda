package fr.diplo.swing.layouts;

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
        /**
         * FlowLayout place les éléments en ligne
         * Par défaut ils sont centrés mais on peut les contrôller pour les positionner à droite, gauche, ..
         * On peut aussi controler les marges hgap et vgap (elles se feront de tous les côtés)
         */
        contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 20,20));
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
