package fr.diplo.swing.test;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MyItellij extends JFrame {

    public MyItellij() {
        super("My first application");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        //contentPane.setLayout(new BorderLayout());

        /**
         * Barre d'outil au nord
         */
        contentPane.add(createToolBar(), BorderLayout.NORTH);

        /**
         * Arborescence à l'ouest
         */
        JScrollPane westComponent = new JScrollPane(new JTree()); // Scroll + arborescence
        westComponent.setPreferredSize(new Dimension(200, 0));
        contentPane.add(westComponent, BorderLayout.WEST);

        /**
         * TextArea au centre
         */
        JTextArea txtContent = new JTextArea("The content of this editor");
        JScrollPane scrContent = new JScrollPane(txtContent);
        contentPane.add(scrContent);

        /**
         * Panneau de 4 boutons à l'est
         */
        contentPane.add(createRightPanel(), BorderLayout.EAST);

        /**
         * Barre de status au sud
         */
        contentPane.add(createStatusBar(), BorderLayout.SOUTH);
    }

    /**
     * Méthode de création de la barre d'outils
     * @return la barre d'outils
     */
    private JToolBar createToolBar() {
        JToolBar toolbar = new JToolBar();

        JButton btnPushme = new JButton("Push me");
        toolbar.add(btnPushme);

        JButton btnClickMe = new JButton("Click me!!!!!!");
        toolbar.add(btnClickMe);

        JCheckBox chkCheckMe = new JCheckBox("Check me!");
        toolbar.add(chkCheckMe);

        JTextField txtEdit = new JTextField("Edit me!");
        txtEdit.setPreferredSize(new Dimension(140,30));
        toolbar.add(txtEdit);

        return toolbar;
    }

    /**
     * Méthode de création de la barre de status
     * @return La barre de status
     */
    private JPanel createStatusBar() {
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel lblStatus1 = new JLabel("Message 1");
        lblStatus1.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus1);

        JLabel lblStatus2 = new JLabel("Message 2");
        lblStatus2.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus2);

        JLabel lblStatus3 = new JLabel("Message 3");
        lblStatus3.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus3);

        return statusBar;
    }

    /**
     * Méthode de création du panneau avec 4 boutons
     * @return le panneau avec 4 boutons
     */
    private JPanel createRightPanel() {
        JPanel panel = new JPanel(new GridLayout(4,1));
        panel.add(new JButton("Button1"));
        panel.add(new JButton("Button2"));
        panel.add(new JButton("Button3"));
        panel.add(new JButton("Button4"));
        return panel;
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyItellij myWindow = new MyItellij();
        myWindow.setVisible(true);
    }

}
