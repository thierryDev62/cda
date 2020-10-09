package fr.diplo.swing.menubar;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MenuBarSample extends JFrame {

    /**
     * Constructeur de l'interface graphique
     */
    public MenuBarSample() {
        super("JMenuBar sample");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        /**
         * Construction de la barre de menu et injection
         */
        this.setJMenuBar(createMenuBar());

    }

    /**
     * Methode de construction de la barre de menu
     * @return
     */
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");

        JMenuItem menuNew = new JMenuItem("New File");
        menuFile.add(menuNew);

        menuBar.add(menuFile);

        return menuBar;
    }

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MenuBarSample window = new MenuBarSample();
        window.setVisible(true);
    }
}
