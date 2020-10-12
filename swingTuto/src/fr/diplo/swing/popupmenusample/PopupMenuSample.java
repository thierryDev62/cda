package fr.diplo.swing.popupmenusample;

import fr.diplo.swing.menubar.MenuBarSample;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PopupMenuSample extends JFrame {
    /* Construction de l'interface graphique */
    public PopupMenuSample() {
        super("JPopupMenu sample");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel contentPane = (JPanel) this.getContentPane();

        // The content of the window
        JScrollPane leftScrollPane = new JScrollPane(new JTree());
        leftScrollPane.setPreferredSize(new Dimension(200,0));

        JTextArea textArea = new JTextArea();
        JScrollPane rightScrollPane = new JScrollPane(textArea);

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane);
        contentPane.add(splitPane);

        // Association d'un popup menu sur la zone d'édition de texte

        // Attention avant Java SE 8.0, il faut un final au début de la déclaration !!!
        JPopupMenu popupMenu = this.createPopupMenu();
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }
    /* Méthode de construction du menu contextuel */
    private JPopupMenu createPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem menuNew = new JMenuItem("New File");

        // Possibilité de remettre des éléments de menuBarSample

        popupMenu.add(menuNew);

        return popupMenu;
    }
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        PopupMenuSample window = new PopupMenuSample();
        window.setVisible(true);
    }
}
