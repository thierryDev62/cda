package fr.diplo.swing.toolbar;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ToolBarSample extends JFrame {

    /**
     * Constructeur de l'interface graphique
     */
    public ToolBarSample() {
        super("JToolBar sample");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        /**
         * Construction de la barre d'outil et injection
         */
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.add(createToolBar(), BorderLayout.NORTH);
    }

    /**
     * Methode de construction de la barre de menu
     */
    private JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();
        JButton btnNew = new JButton(new ImageIcon("icons/new.png"));
        btnNew.addActionListener(this::btnNewListener);
        btnNew.setToolTipText("New File CTRL+N");
        toolBar.add(btnNew);

        // Possibilité d'ajouter d'autres éléments comme dans MenuBarSample
        toolBar.addSeparator();
        toolBar.add(new JCheckBox("Check me"));
        toolBar.addSeparator();
        toolBar.add(new JTextField("Edit me"));
        return toolBar;
    }

    private void btnNewListener(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "New document is required");
    }

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        ToolBarSample window = new ToolBarSample();
        window.setVisible(true);
    }
}
