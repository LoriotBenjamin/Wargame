package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;

/**
 * Regles est une classe qui affiche les règles du jeu.
 * @author Solenn
 *
 */
public class Regles {

    /**
     * Fenêtre des règles.
     */
    private JFrame frame;
    /**
     * String pour représenter le séparateur de fichier que ce soit sur Linux ou
     * Windows.
     */
    private String separateur = System.getProperty("file.separator");

    /**
     * Crée l'application.
     */
    public Regles() {
        initialize();

    }

    /**
     * Initialise le contenu de la fenêtre.
     */
    private void initialize() {

        Dimension size = new Dimension(1300, 650);
        frame = new JFrame("Wargame");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(size);
        frame.setMaximumSize(size);
        frame.setMinimumSize(size);

        JLabel label = new JLabel();
        JLabel labelP1 = new JLabel();
        JLabel labelP2 = new JLabel();
        JLabel labelP3 = new JLabel();
        JLabel labelP4 = new JLabel();
        JLabel labelP5 = new JLabel();
        JLabel labelTerrain = new JLabel();

        label.setText(
                "<html><body><font size=\"+1\">Wargame est une succession de tours de jeu. Chaque tour permet"
                        + " successivement aux </font><p><b> "
                        + "<font size=\"+1\">adversaires d'effectuer diverses actions. Un joueur peut jouer tant"
                        + " qu'une de ses unités   </font>"
                        + "</b><p>possède des points de déplacement. Quand un adversaire a terminé ses déplacements,"
                        + "  il "
                        + "</b><p> passe la main au joueur suivant. Eventuellement, "
                        + "il peut rester des points de déplacement  " + "</b><p>à certaines de ces unités. "
                        + "</b><p>La partie se termine lors de la destruction complète de l'armée adverse"
                        + "</body></html>");
        label.setFont(new Font("Serif", Font.BOLD, 17));
        label.setForeground(Color.white);
        labelP1.setText(
                "<html><body><font size=\"+1\">Le Guerrier dispose d'un potentiel d'attaque égal à 18 points "
                        + "</font><p><b> "
                        + "<font size=\"+1\">Un potentiel de défense égal à 10 points   </font>"
                        + "</b><p>Des points de vie égaux à 46, une vitesse de déplacement égale à 3, "
                        + "</b><p>Une vision égale à 2 et la portée est égale à 1 point" + " " + "</body></html>");

        labelP1.setFont(new Font("Serif", Font.BOLD, 17));
        labelP1.setForeground(Color.white);

        labelP2.setText(
                "<html><body><font size=\"+1\">Le Mage dispose d'un potentiel d'attaque égal à 16 points </font><p><b> "
                        + "<font size=\"+1\">Un potentiel de défense égal à 4 points   </font>"
                        + "</b><p>Des points de vie égaux à 34, une vitesse de déplacement égale à 3, "
                        + "</b><p>Une vision égale à 3 et la portée est égale à 2 points" + " " + "</body></html>");

        labelP2.setFont(new Font("Serif", Font.BOLD, 17));
        labelP2.setForeground(Color.white);

        labelP3.setText(
                "<html><body><font size=\"+1\">L'Archer dispose d'un potentiel d'attaque égal à 14 points </font><p><b>"
                        + "<font size=\"+1\">Un potentiel de défense égal à 6 points   </font>"
                        + "</b><p>Des points de vie égaux à 38, une vitesse de déplacement égale à 4. "
                        + "</b><p>Une vision égale à 4 et la portée est égale à 3 points" + " " + "</body></html>");

        labelP3.setFont(new Font("Serif", Font.BOLD, 17));
        labelP3.setForeground(Color.white);

        labelP4.setText(
                "<html><body><font size=\"+1\">Le Prêtre dispose d'un potentiel d'attaque égal à 6 points </font><p><b>"
                        + "<font size=\"+1\">Un potentiel de défense égal à 4 points   </font>"
                        + "</b><p>Des points de vie égaux à 40, une vitesse de déplacement égale à 4. "
                        + "</b><p>Une vision égale à 2 et la portée est égale à 1 point" + " " + "</body></html>");

        labelP4.setFont(new Font("Serif", Font.BOLD, 17));
        labelP4.setForeground(Color.white);

        labelP5.setText(
                "<html><body><font size=\"+1\">Le Chevalier dispose d'un potentiel d'attaque égal à 20 points "
                        + "</font><p><b> "
                        + "<font size=\"+1\">Un potentiel de défense égal à 8 points   </font>"
                        + "</b><p>Des points de vie égaux à 50, une vitesse de déplacement égale à 6."
                        + "</b><p>Une vision égale à 2 et la portée est égale à 1 point" + " " + "</body></html>");

        labelP5.setFont(new Font("Serif", Font.BOLD, 17));
        labelP5.setForeground(Color.white);

        labelTerrain.setText(
                "<html><body><font size=\"+1\">La Forêt utilise 2 points de déplacement et octroit 50% de défense."
                        + "</font><p><b>"
                        + "<font size=\"+1\">La Montagne utilise 3 points de déplacement et octroit 70% de défense."
                        + "</font></b><p>"
                        + "<font size=\"+1\">La Plaine utilise 1 point de déplacement et octroit 10% de défense."
                        + "</font></b><p>"
                        + "<font size=\"+1\">La Désert utilise 2 points de déplacement et octroit 10% de défense."
                        + "</font></b><p>"
                        + "<font size=\"+1\">La Rivière utilise 2 points de déplacement et octroit 10% de défense."
                        + "</font></b><p>"
                        + "<font size=\"+1\">La Mer est une zone où il est impossible de se déplacer.</font></b><p>"
                        + "<font size=\"+1\">Le Village utilise 1 point de déplacement et octroit 30% de défense."
                        + "</font>"
                        + " " + "</body></html>");
        labelTerrain.setFont(new Font("Serif", Font.BOLD, 17));
        labelTerrain.setForeground(Color.white);

        Image imagefond = null;
        try {
            imagefond = ImageIO.read(new File("images" + separateur + "regles.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        JButton exit = new JButton("Retour au Menu");
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                frame.dispose();
            }
        });
        CustomPanel panel = new CustomPanel(imagefond);

        SpringLayout sl_panel = new SpringLayout();
        panel.setPreferredSize(new Dimension(1250, 1300));
        panel.setLayout(sl_panel);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        sl_panel.putConstraint(SpringLayout.NORTH, label, 150, SpringLayout.NORTH, panel);
        sl_panel.putConstraint(SpringLayout.WEST, label, 290, SpringLayout.WEST, panel);

        sl_panel.putConstraint(SpringLayout.WEST, labelP1, 100, SpringLayout.WEST, label);
        sl_panel.putConstraint(SpringLayout.SOUTH, labelP1, 360, SpringLayout.NORTH, label);

        sl_panel.putConstraint(SpringLayout.WEST, labelP2, 0, SpringLayout.WEST, labelP1);
        sl_panel.putConstraint(SpringLayout.SOUTH, labelP2, 200, SpringLayout.NORTH, labelP1);

        sl_panel.putConstraint(SpringLayout.WEST, labelP3, 0, SpringLayout.WEST, labelP2);
        sl_panel.putConstraint(SpringLayout.SOUTH, labelP3, 200, SpringLayout.NORTH, labelP2);

        sl_panel.putConstraint(SpringLayout.WEST, labelP4, 0, SpringLayout.WEST, labelP3);
        sl_panel.putConstraint(SpringLayout.SOUTH, labelP4, 200, SpringLayout.NORTH, labelP3);

        sl_panel.putConstraint(SpringLayout.WEST, labelP5, 0, SpringLayout.WEST, labelP4);
        sl_panel.putConstraint(SpringLayout.SOUTH, labelP5, 200, SpringLayout.NORTH, labelP4);

        sl_panel.putConstraint(SpringLayout.WEST, labelTerrain, 0, SpringLayout.WEST, labelP5);
        sl_panel.putConstraint(SpringLayout.SOUTH, labelTerrain, 300, SpringLayout.NORTH, labelP5);

        sl_panel.putConstraint(SpringLayout.WEST, exit, 100, SpringLayout.WEST, labelTerrain);
        sl_panel.putConstraint(SpringLayout.SOUTH, exit, 250, SpringLayout.NORTH, labelTerrain);

        panel.add(label);
        panel.add(labelP1);
        panel.add(labelP2);
        panel.add(labelP3);
        panel.add(labelP4);
        panel.add(labelP5);
        panel.add(labelTerrain);
        panel.add(exit);

        JScrollPane sp = new JScrollPane();

        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setViewportView(panel);
        sp.setPreferredSize(new Dimension(1300, 650));

        frame.add(sp); // add scrollpane to frame

        frame.pack();
        frame.setVisible(true);
    }

}

