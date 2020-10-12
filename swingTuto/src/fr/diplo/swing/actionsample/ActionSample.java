package fr.diplo.swing.actionsample;

import fr.diplo.swing.menubar.MenuBarSample;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActionSample extends JFrame {
    /* Construction de l'interface graphique */
    public ActionSample() {
        super("Swing Action sample");
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Construction et injection de la barre de menu
        this.setJMenuBar(this.createMenuBar());

        // Construction et injection de la barre d'outils
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.add(this.createToolBar(), BorderLayout.NORTH);

        // The content of the window
        JScrollPane leftScrollPane = new JScrollPane(new JTree());
        leftScrollPane.setPreferredSize(new Dimension(200, 0));

        JTextArea textArea = new JTextArea();
        JScrollPane rightScrollPane = new JScrollPane(textArea);

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane
        );
        contentPane.add(splitPane);

        // Association d'un popup menu sur la zone d'édition de texte
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

    private JPopupMenu createPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(actNew); // Appel de l'action

        return popupMenu;
    }

    private JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();

        JButton btnNew = toolBar.add(actNew); // Appel de l'action
        btnNew.setHideActionText(false); // Affiche le texte sous le bouton

        return toolBar;
    }

    private JMenuBar createMenuBar() {

        // La barre de menu à proprement parlé
        JMenuBar menuBar = new JMenuBar();

        // Définition du menu déroulant "File" et de son contenu
        JMenu menuFile = new JMenu("File");
        menuFile.setMnemonic('F');

        menuFile.add(actNew);

        menuBar.add(menuFile); // Appel de l'action

        return menuBar;
    }

    /* Nos diverses actions */
    private AbstractAction actNew = new AbstractAction() {
        {   // Le constructeur de votre classe anonyme
            putValue( Action.NAME, "New File" );
            putValue( Action.SMALL_ICON, new ImageIcon( "icons/new.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_N );
            putValue( Action.SHORT_DESCRIPTION, "New file... (CTRL+N)" );       // ToolTipText sur tool bar
            putValue( Action.ACCELERATOR_KEY,
                    KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK ) );
        }

        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "New" );
        }
    };

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        ActionSample window = new ActionSample();
        window.setVisible(true);
    }
}
