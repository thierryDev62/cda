package fr.diplo.swing.menubar;

import fr.diplo.swing.listener.MyWindowListener4;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

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

        /**
         * Menu File
         */
        JMenu menuFile = new JMenu("File");
        menuFile.setMnemonic('F');

        // New File
        JMenuItem menuNew = new JMenuItem("New File");
        menuNew.setMnemonic('N');
        menuNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        menuNew.setIcon(new ImageIcon("icons/new.png"));
        menuNew.addActionListener(this::menuNewListener);
        menuFile.add(menuNew);

        // Séparateur
        menuFile.addSeparator();

        // Open File
        JMenuItem menuOpen = new JMenuItem("Open File...");
        menuOpen.setMnemonic('O');
        menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        menuOpen.setIcon(new ImageIcon("icons/open.png"));
        menuOpen.addActionListener(this::menuOpenListener);
        menuFile.add(menuOpen);

        // Save File
        JMenuItem menuSaveFile = new JMenuItem("Save File...");
        menuSaveFile.setMnemonic('S');
        menuSaveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        menuSaveFile.setIcon(new ImageIcon("icons/save.png"));
        menuSaveFile.addActionListener(this::menuSaveFile);
        menuFile.add(menuSaveFile);

        // Save File As
        JMenuItem menuSaveFileAs = new JMenuItem("Save File As...");
        menuSaveFileAs.setMnemonic('A');
        menuSaveFileAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        menuSaveFileAs.setIcon(new ImageIcon("icons/save_as.png"));
        menuSaveFileAs.addActionListener(this::menuSaveFileAs);
        menuFile.add(menuSaveFileAs);

        // Séparateur
        menuFile.addSeparator();

        // Exit
        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.setMnemonic('P');
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        menuExit.setIcon(new ImageIcon("icons/exit.png"));
        menuExit.addActionListener(this::menuExit);
        menuFile.add(menuExit);

        menuBar.add(menuFile);

        /**
         * Menu Edit
         */
        JMenu menuEdit = new JMenu("Edit");
        menuEdit.setMnemonic('E');

        // Undo
        JMenuItem menuUndo = new JMenuItem("Undo");
        menuUndo.setMnemonic('U');
        menuUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK));
        menuUndo.setIcon(new ImageIcon("icons/undo.png"));
        menuUndo.addActionListener(this::menuUndo);
        menuEdit.add(menuUndo);

        // Redo
        JMenuItem menuRedo = new JMenuItem("Redo");
        menuRedo.setMnemonic('R');
        menuRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
        menuRedo.setIcon(new ImageIcon("icons/redo.png"));
        menuRedo.addActionListener(this::menuRedo);
        menuEdit.add(menuRedo);

        // Séparateur
        menuEdit.addSeparator();

        // Copy
        JMenuItem menuCopy = new JMenuItem("Copy");
        menuCopy.setMnemonic('C');
        menuCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        menuCopy.setIcon(new ImageIcon("icons/copy.png"));
        menuCopy.addActionListener(this::menuCopy);
        menuEdit.add(menuCopy);

        // Cut
        JMenuItem menuCut = new JMenuItem("Cut");
        menuCut.setMnemonic('X');
        menuCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        menuCut.setIcon(new ImageIcon("icons/cut.png"));
        menuCut.addActionListener(this::menuCut);
        menuEdit.add(menuCut);

        // Paste
        JMenuItem menuPaste = new JMenuItem("Paste");
        menuPaste.setMnemonic('V');
        menuPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        menuPaste.setIcon(new ImageIcon("icons/paste.png"));
        menuPaste.addActionListener(this::menuPaste);
        menuEdit.add(menuPaste);

        menuBar.add(menuEdit);

        /**
         * Menu Help
         */
        JMenu menuHelp = new JMenu("Help");
        menuHelp.setMnemonic('H');

        JMenuItem menuHelpMe = new JMenuItem("Help me!");
        menuHelpMe.setMnemonic('D');
        menuHelpMe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
        menuHelpMe.setIcon(new ImageIcon("icons/help.png"));
        menuHelpMe.addActionListener(this::menuHelp);
        menuHelp.add(menuHelpMe);

        menuBar.add(menuHelp);

        return menuBar;
    }

    private void menuNewListener(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "New document is required");
    }

    private void menuOpenListener(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Open a file");
    }

    private void menuSaveFile(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Save");
    }

    private void menuSaveFileAs(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Save as");
    }

    private void menuExit(ActionEvent e) {
        int clickedButton = JOptionPane.showConfirmDialog(MenuBarSample.this,
                "Etes-vous sûr de vouloir quitter ?", "Title", JOptionPane.YES_NO_OPTION);
        if(clickedButton == JOptionPane.YES_OPTION) {
            //MyWindowListener4.this.dispose(); ou ->
            dispose();
        }
    }

    private void menuUndo(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Undo");
    }

    private void menuRedo(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Redo");
    }

    private void menuCopy(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Copy");
    }

    private void menuCut(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Cut");
    }

    private void menuPaste(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Paste");
    }

    private void menuHelp(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Read the doc...");
    }

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MenuBarSample window = new MenuBarSample();
        window.setVisible(true);
    }
}
